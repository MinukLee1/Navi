package com.tennessee.project_navi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
    Button btnLogin, btnJoin, btngotoPassreset;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        setTheme(R.style.AppTheme);

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
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                       /* intent.putExtra("name", result.getKakaoAccount().getProfile().getNickname());
                        intent.putExtra("email",result.getKakaoAccount().getEmail());
                        intent.putExtra("profileImg",result.getKakaoAccount().getProfile().getProfileImageUrl());*/
                        startActivity(intent);

                        Toast.makeText(LoginActivity.this,"로그인에 성공하였습니다.",Toast.LENGTH_SHORT).show();

                    }
                });
            }

            @Override
            public void onSessionOpenFailed(KakaoException exception) {
                Toast.makeText(LoginActivity.this, "onSessionOpenFailed",Toast.LENGTH_SHORT).show();
            }

        };
        // -> 틀릴시 에러 메시지 뜨긴하는데 변수 이중설정 필요성 ?
        Login_ID = findViewById(R.id.login_ID);
        Login_Pass = findViewById(R.id.emailEditText);


        btnLogin = findViewById(R.id.btnLogin);
        btnJoin = findViewById(R.id.btnJoin);
        btngotoPassreset = findViewById(R.id.btngotoPassreset);

        // Intent 넘기는건 Login() Method 안에서 실행
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, JoinActivity.class);
                startActivity(intent);
            }
        });
        btngotoPassreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartMyActivity(PassresetActivity.class);
            }
        });


    }

    private void Login() {

        String email = ((EditText) findViewById(R.id.login_ID)).getText().toString();
        String password = ((EditText) findViewById(R.id.emailEditText)).getText().toString();


        if (email.length() > 0 && password.length() > 0) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                startToast("로그인에 성공하였습니다.");
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
         intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
         startActivity(intent);
    }

}

