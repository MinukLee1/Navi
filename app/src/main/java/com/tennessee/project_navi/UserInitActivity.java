package com.tennessee.project_navi;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.CursorLoader;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

public class UserInitActivity extends Activity {
    private static final String TAG ="UserInitActivity";

    public static final int PICK_FROM_ALBUM = 1;
    private FirebaseStorage mStorage;
    private FirebaseDatabase mDatabase;
    private FirebaseAuth mAuth;
    private Uri imageUri;
    private String pathUri;
    private File tempFile;
    private ImageView profileImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinit_page);


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mStorage = FirebaseStorage.getInstance();
        profileImage = findViewById(R.id.profileImage);


        //프로필 이미지 변경 리스너
        /*findViewById(R.id.profileImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //사진 찍기로 이동
                StartMyActivity(CameraActivity.class);
            }
        });;*/
        findViewById(R.id.profileImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoAlbum();
            }
        });

        //회원정보 저장 버튼
        findViewById(R.id.btnInfoOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileUpdate();
            }
        });;




    }

    // 앨범 메소드
    private void gotoAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode != RESULT_OK) { // 코드가 틀릴경우
            startToast("회원가입을 취소하였습니다");
            if (tempFile != null) {
                if (tempFile.exists()) {
                    if (tempFile.delete()) {
                        Log.e(TAG, tempFile.getAbsolutePath() + " 삭제 성공");
                        tempFile = null;
                    }
                }
            }
            return;
        }
        switch (requestCode) {
            case PICK_FROM_ALBUM: { // 코드 일치
                // Uri
                imageUri = data.getData();
                pathUri = getPath(data.getData());
                Log.d(TAG, "PICK_FROM_ALBUM photoUri : " + imageUri);
                profileImage.setImageURI(imageUri); // 이미지 띄움
                break;
            }
        }
    }

    // uri 절대경로 가져오기
    public String getPath(Uri uri) {

        String[] proj = {MediaStore.Images.Media._ID};
        CursorLoader cursorLoader = new CursorLoader(this, uri, proj, null, null, null);

        Cursor cursor = cursorLoader.loadInBackground();
        int index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID);

        cursor.moveToFirst();
        return cursor.getString(index);
    }

    //뒤로가기
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    //회원정보 등록
    private void profileUpdate() {


        String name = ((EditText) findViewById(R.id.IdEditText)).getText().toString();
        String phoneNumber = ((EditText) findViewById(R.id.phoneNumber)).getText().toString();
        String birthDay = ((EditText) findViewById(R.id.birthDayEditText)).getText().toString();
        String address = ((EditText) findViewById(R.id.addressEditText)).getText().toString();
        ImageView profileImage = ((ImageView) findViewById(R.id.profileImage));

        if (profileImage != null && name.length() > 0 && phoneNumber.length() > 9 && birthDay.length() > 5 && address.length() > 0 ) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            //사용자 정보 초기화
            UserInfo userInfo = new UserInfo( name, phoneNumber, birthDay, address, profileImage);

            if (user != null  ) {

                db.collection("users").document(user.getUid()).set(userInfo)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

                                final Uri file = Uri.fromFile(new File(pathUri)); // path

                                // 스토리지에 방생성 후 선택한 이미지 넣음
                                StorageReference storageReference = mStorage.getReference()
                                        .child("users").child("uid/"+file.getLastPathSegment());
                                storageReference.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                 @Override
                                 public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                                     final Task<Uri> imageUrl = task.getResult().getStorage().getDownloadUrl();
                                              userInfo.setName(name);
                                             Glide.with(userInfo.getProfileImage()).load(imageUrl.getResult().toString());
                                             // database에 저장
                                             mDatabase.getReference().child("users").child(name)
                                                     .setValue(userInfo);
                                                                                                         }
                                                                                                     });
                                startToast("회원가입에 성공하였습니다.");
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                startToast("회원정보 등록에 실패하였습니다");
                                Log.v(TAG, "Error writting document",e);
                            }
                        });
            }
        } else {
            startToast("프로필사진 및 회원정보 입력은 필수입니다");
        }
    }

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void StartMyActivity(Class c){
        Intent intent = new Intent(this, c);
        startActivityForResult(intent,0);
    }


}

