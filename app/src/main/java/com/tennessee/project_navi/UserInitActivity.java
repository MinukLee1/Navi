package com.tennessee.project_navi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserInitActivity extends Activity {
    private static final String TAG ="UserInitActivity";



    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinit_page);



        //프로필 이미지 변경 리스너
        findViewById(R.id.profileImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //사진 찍기로 이동
                StartMyActivity(CameraActivity.class);
            }
        });;

        //회원정보 저장 버튼
        findViewById(R.id.btnInfoOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileUpdate();
            }
        });;




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


        if (name.length() > 0 && phoneNumber.length() > 9 && birthDay.length() > 5 && address.length() > 0) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseFirestore db = FirebaseFirestore.getInstance();


            //사용자 정보 초기화
            UserInfo userInfo = new UserInfo(name, phoneNumber, birthDay, address);

            if (user != null) {

                db.collection("users").document(user.getUid()).set(userInfo)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
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
            startToast("회원정보를 입력해주세요!");
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

