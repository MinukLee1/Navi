package com.tennessee.project_navi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class JoinActivity extends Activity {
    TextView txtAlert;
    EditText txtID, txtPass, txtPassCk, txtName;
    Button btnOKJoin, btndel;
    ImageView Gif;


    private static final String TAG = "JoinActivity";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_page);

        //gif
        Gif = findViewById(R.id.naviGif);
        Glide.with(this).load(R.raw.navi).into(Gif);


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        txtID = findViewById(R.id.txtID);
        txtPass = findViewById(R.id.txtPass);
        txtPassCk = findViewById(R.id.txtPassCk);
        txtAlert = findViewById(R.id.txtAlert);

        btnOKJoin = findViewById(R.id.btnOKJoin);
        btndel = findViewById(R.id.btndel);

        //비밀번호 일치 불일치
        txtPassCk.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                //일치 할 경우 출력
                if (txtPass.getText().toString().equals(txtPassCk.getText().toString())) {
                    txtAlert.setText("비밀번호가 일치합니다.");
                }
                //불일치 할 경우 출력
                else {
                    txtAlert.setText("비밀번호가 일치하지 않습니다.다시 입력해주세요.");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnOKJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Join();

            }
        });
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    private void Join() {

        String email = ((EditText) findViewById(R.id.txtID)).getText().toString();
        String password = ((EditText) findViewById(R.id.txtPass)).getText().toString();
        String passwordCheck = ((EditText) findViewById(R.id.txtPassCk)).getText().toString();

        if(email.length() > 0 && password.length() >0 && passwordCheck.length() > 0){

            if (password.equals(passwordCheck)) {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, (task) ->  {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                FirebaseUser user = mAuth.getCurrentUser();

                                StartMyActivity(UserInitActivity.class);
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                if(task.getException() != null) {
                                    startToast(task.getException().toString());

                                }
                            }

                        });

            }else {
                startToast("비밀번호가 일치하지 않습니다.");
            }
        }else{
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