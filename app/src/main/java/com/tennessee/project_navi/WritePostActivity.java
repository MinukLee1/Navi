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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

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
    private int pathCount, successCount;
    private RelativeLayout btnBackLayout, loaderLayout;
    private ImageView selectedImageView;
    private EditText selectedEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_post);

        parent = findViewById(R.id.contentsLayout);
        btnBackLayout = findViewById(R.id.btnBackLayout);
        loaderLayout = findViewById(R.id.loaderLayout);

        btnBackLayout.setOnClickListener(onClickListener);
        findViewById(R.id.btncheck).setOnClickListener(onClickListener);
        findViewById(R.id.btnImage).setOnClickListener(onClickListener);
        findViewById(R.id.btnVideo).setOnClickListener(onClickListener);
        findViewById(R.id.imageModify).setOnClickListener(onClickListener);
        findViewById(R.id.videoModify).setOnClickListener(onClickListener);
        findViewById(R.id.delete).setOnClickListener(onClickListener);
        findViewById(R.id.contentsEditText).setOnFocusChangeListener(onFocusChangeListener);
        findViewById(R.id.titleEditText).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    selectedEditText = null;
                }
            }
        });
    }

    @Override
    public void  onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0:
                if (resultCode == Activity.RESULT_OK){
                    String profilePath = data.getStringExtra("profilePath");
                    pathList.add(profilePath);

                    ViewGroup.LayoutParams layoutParams =
                            new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

                    LinearLayout linearLayout = new LinearLayout(WritePostActivity.this);
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setOrientation(LinearLayout.VERTICAL);

                    if (selectedEditText == null){
                        parent.addView(linearLayout);
                    }else {
                        for (int i=0; i < parent.getChildCount(); i++){
                            if (parent.getChildAt(i) == selectedEditText.getParent()){
                                parent.addView(linearLayout, i + 1);
                                break;
                            }
                        }
                    }

                    ImageView imageView = new ImageView(WritePostActivity.this);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            btnBackLayout.setVisibility(View.VISIBLE);
                            selectedImageView = (ImageView) v;
                        }
                    });


                    Glide.with(this).load(profilePath).override(1000).into(imageView);
                    linearLayout.addView(imageView);

                    EditText editText = new EditText(WritePostActivity.this);
                    editText.setLayoutParams(layoutParams);
                    editText.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE | InputType.TYPE_CLASS_TEXT);
                    editText.setHint("내용");
                    editText.setOnFocusChangeListener(onFocusChangeListener);
                    linearLayout.addView(editText);
                }
                break;
            case 1:
                if (resultCode == Activity.RESULT_OK){
                String profilePath = data.getStringExtra("profilePath");
                Glide.with(this).load(profilePath).override(1000).into(selectedImageView);
            }
                break;
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
                    StartMyActivity(GalleryActivity.class, "image",0);
                    break;
                case R.id.btnVideo:
                    StartMyActivity(GalleryActivity.class, "video",0);
                    break;
                case R.id.btnBackLayout:
                    if (btnBackLayout.getVisibility() == View.VISIBLE){
                        btnBackLayout.setVisibility(View.GONE);
                    }
                    break;
                case  R.id.imageModify:
                    StartMyActivity(GalleryActivity.class, "imageModify",1);
                    btnBackLayout.setVisibility(View.GONE);
                    break;
                case  R.id.videoModify:
                    StartMyActivity(GalleryActivity.class, "videoModify",1);
                    btnBackLayout.setVisibility(View.GONE);
                    break;
                case  R.id.delete:
                    parent.removeView((View) selectedImageView.getParent());
                    btnBackLayout.setVisibility(View.GONE);
                    break;
            }
        }
    };

    View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                selectedEditText = (EditText) v;
            }
        }
    };

    private void storageUploader() {
        final String title = ((EditText) findViewById(R.id.titleEditText)).getText().toString();

        if (title.length() > 0) {
            loaderLayout.setVisibility(View.VISIBLE);
            ArrayList<String> contentsList = new ArrayList<>();
            user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageRef = storage.getReference();
            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
            final DocumentReference documentReference = firebaseFirestore.collection("feeds").document();

            for (int i=0; i < parent.getChildCount(); i++){
                LinearLayout linearLayout = (LinearLayout) parent.getChildAt(i);
                for (int ii = 0; ii < linearLayout.getChildCount(); ii++){
                    View view = linearLayout.getChildAt(ii);
                    if (view instanceof EditText){
                        String text = ((EditText)view).getText().toString();
                        if (text.length() > 0){
                            contentsList.add(text);
                        }
                    }else {
                        contentsList.add(pathList.get(pathCount));
                        final StorageReference mountainImagesRef = storageRef.child("feeds/" + documentReference.getId() + "/"+pathCount+".jpg");

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
                                                startToast("게시글 등록에 성공하였습니다");
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
            if (pathList.size() == 0){
                WriteInfo writeInfo = new WriteInfo(title, contentsList, user.getUid(), new Date());
                Uploader(documentReference, writeInfo);
                startToast("게시글 등록에 성공하였습니다");
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
                        loaderLayout.setVisibility(View.GONE);
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG,"Error writing document", e);
                        loaderLayout.setVisibility(View.GONE);
                    }
                });
    }

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void StartMyActivity(Class c, String media, int requestCode){
        Intent intent = new Intent(this, c);
        intent.putExtra("media", media);
        startActivityForResult(intent,requestCode);
    }
}
