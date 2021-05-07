package com.tennessee.project_navi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class JoinActivity extends Activity {
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

        btnOKJoin = findViewById(R.id.btnOKJoin);
        btndel = findViewById(R.id.btndel);

        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
