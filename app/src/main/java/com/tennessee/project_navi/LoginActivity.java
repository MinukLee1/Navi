package com.tennessee.project_navi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.kakao.auth.ISessionCallback;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.util.exception.KakaoException;

public class LoginActivity extends Activity {


    private ISessionCallback mSessionCallback;

    EditText Login_ID, Login_Pass;
    Button btnLogin, btnJoin, btnPassreset;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        //카카오톡 로그인 메소드
        mSessionCallback = new ISessionCallback() {
            @Override
            public void onSessionOpened() {
                // 로그인 요청
                UserManagement.getInstance().me(new MeV2ResponseCallback() {
                    @Override
                    public void onFailure(ErrorResult errorResult) {
                        //로그인 실패
                        Toast.makeText(LoginActivity.this,"로그인에 실패하였습니다.",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSessionClosed(ErrorResult errorResult) {
                        // 세션이 닫힘
                        Toast.makeText(LoginActivity.this,"세션이 닫혔습니다..다시 시도해주세요",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(MeV2Response result) {
                        // 로그인 성공

                       /* intent.putExtra("name", result.getKakaoAccount().getProfile().getNickname());
                        intent.putExtra("email",result.getKakaoAccount().getEmail());
                        intent.putExtra("profileImg",result.getKakaoAccount().getProfile().getProfileImageUrl());*/


                        Toast.makeText(LoginActivity.this,"로그인에 성공하였습니다.",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onSessionOpenFailed(KakaoException exception) {
                Toast.makeText(LoginActivity.this, "onSessionOpenFailed",Toast.LENGTH_SHORT).show();
            }

        };


        Login_ID = findViewById(R.id.IdEditText);
        Login_Pass = findViewById(R.id.phoneNumber);

        btnLogin = findViewById(R.id.btnLogin);
        btnJoin = findViewById(R.id.btnJoin);
        btnPassreset = findViewById(R.id.btnInfoOk);

        // 로그인 버튼  / Intent 넘기는건 Login() Method 안에서 실행
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StartMyActivity(JoinActivity.class);
            }
        });
        btnPassreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartMyActivity(PassresetActivity.class);
            }
        });


    }

    private void Login() {

        String email = ((EditText) findViewById(R.id.IdEditText)).getText().toString();
        String password = ((EditText) findViewById(R.id.phoneNumber)).getText().toString();


        if (email.length() > 0 && password.length() > 0) {
            RelativeLayout loderLayout = findViewById(R.id.loaderLayout);
            loderLayout.setVisibility(View.VISIBLE);
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            loderLayout.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                startToast("로그인에 성공하였습니다.");
                           finish();
                                    StartMyActivity(MainActivity.class);
                            } else {
                                if(task.getException() != null){
                                    startToast(task.getException().toString());
                                }

                            }
                        }
                    });
        } else {
            startToast("이메일 또는 비밀번호를 입력해 주세요");
        }
    }

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void StartMyActivity(Class c){
         Intent intent = new Intent(this, c);
         startActivity(intent);
    }

}

