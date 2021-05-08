package com.tennessee.project_navi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class JoinActivity extends Activity {
    TextView txtAlert;
    EditText txtID, txtPass, txtPassCk, txtName;
    Button btnOKJoin, btndel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_page);

        txtID = findViewById(R.id.txtID);
        txtPass = findViewById(R.id.txtPass);
        txtPassCk = findViewById(R.id.txtPassCk);
        txtName = findViewById(R.id.txtName);
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

        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
