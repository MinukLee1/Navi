package com.tennessee.project_navi;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;


public class WritePostActivity extends Activity {
    private static final String TAG = "WritePostActivity";
    private FirebaseUser user;
    private ArrayList<String> pathList = new ArrayList<>();
    private LinearLayout parent;
    private int pathCount;
    private int successCount;
    private RelativeLayout btnBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_post);

        parent = findViewById(R.id.contentsLayout);
        btnBackLayout = findViewById(R.id.btnBackLayout);

        btnBackLayout.setOnClickListener(onClickListener);
        findViewById(R.id.btncheck).setOnClickListener(onClickListener);
        findViewById(R.id.btnImage).setOnClickListener(onClickListener);
        findViewById(R.id.btnVideo).setOnClickListener(onClickListener);

    }
    @Override
    public void  onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0: {
                if (resultCode == Activity.RESULT_OK){
                    String profilePath = data.getStringExtra("profilePath");
                    pathList.add(profilePath);

                    ViewGroup.LayoutParams layoutParams =
                            new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

                    ImageView imageView = new ImageView(WritePostActivity.this);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            btnBackLayout.setVisibility(View.VISIBLE);
                        }
                    });
                    Glide.with(this).load(profilePath).override(1000).into(imageView);
                    parent.addView(imageView);

                    EditText editText = new EditText(WritePostActivity.this);
                    editText.setLayoutParams(layoutParams);
                    editText.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE | InputType.TYPE_CLASS_TEXT);
                    editText.setHint("내용");
                    parent.addView(editText);
                }
                break;
            }
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.btncheck:
                    storageUploader();
                    break;
                case R.id.btnImage:
                    StartMyActivity(GalleryActivity.class, "image");
                    break;
                case R.id.btnVideo:
                    StartMyActivity(GalleryActivity.class, "video");
                    break;
                case R.id.btnBackLayout:
                    if (btnBackLayout.getVisibility() == View.VISIBLE){
                        btnBackLayout.setVisibility(View.GONE);
                    }
                    break;
            }
        }
    };

    private void storageUploader() {
        final String title = ((EditText) findViewById(R.id.TitleEditText)).getText().toString();

        if (title.length() > 0) {
            ArrayList<String> contentsList = new ArrayList<>();
            user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageRef = storage.getReference();
            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
            final DocumentReference documentReference = firebaseFirestore.collection("feeds").document();

            for (int i=0; i < parent.getChildCount(); i++){
                View view = parent.getChildAt(i);
                if (view instanceof EditText){
                    String text = ((EditText)view).getText().toString();
                    if (text.length() > 0){
                        contentsList.add(text);
                    }
                }else {
                    contentsList.add(pathList.get(pathCount));
                    final StorageReference mountainImagesRef = storageRef.child("posts/" + documentReference.getId() + "/"+pathCount+".jpg");

                    try {
                        InputStream stream = new FileInputStream(new File(pathList.get(pathCount)));
                        StorageMetadata metadata = new StorageMetadata.Builder().setCustomMetadata("index",""+(contentsList.size()-1)).build();
                        UploadTask uploadTask = mountainImagesRef.putStream(stream, metadata);
                        uploadTask.addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                //
                            }
                        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            final int index = Integer.parseInt(taskSnapshot.getMetadata().getCustomMetadata("index"));
                            mountainImagesRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    contentsList.set(index, uri.toString());
                                    successCount++;
                                    if (pathList.size() == successCount){
                                        //완료
                                        WriteInfo writeInfo = new WriteInfo(title, contentsList, user.getUid(), new Date());
                                        Uploader(documentReference, writeInfo);
                                    }
                                }
                            });

                        }
                        });
                    }catch (FileNotFoundException e){
                        Log.e("로그","에러: " + e.toString());
                    }
                    pathCount++;
                }
            }
            }
        else {
            startToast("제목,내용,카테고리는 필수입력항목입니다");
        }
    }

    private void Uploader(DocumentReference documentReference, WriteInfo writeInfo) {
        documentReference.set(writeInfo)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG,"DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG,"Error writing document", e);
                    }
                });
    }

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void StartMyActivity(Class c, String media){
        Intent intent = new Intent(this, c);
        intent.putExtra("media", media);
        startActivityForResult(intent,0);
    }
}
