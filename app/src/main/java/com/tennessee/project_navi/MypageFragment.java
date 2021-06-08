package com.tennessee.project_navi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MypageFragment extends Fragment {

Button logincheckBtn;
EditText IdEditText;
EditText phoneNumber;
EditText birthDayEditText;
EditText addressEditText;

    public MypageFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        // Inflate the layout for this fragment
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.mypage_fragment,container,false);


        IdEditText = rootview.findViewById(R.id.IdEditText);
        phoneNumber = rootview.findViewById(R.id.phoneNumber);
        birthDayEditText = rootview.findViewById(R.id.birthDayEditText);
        addressEditText = rootview.findViewById(R.id.addressEditText);

        logincheckBtn = rootview.findViewById(R.id.logincheckBtn);

        //로그인 안되어있을시 ,
        if(user == null) {
            IdEditText.setText("로그인 후 확인가능합니다");
            IdEditText.setEnabled(false);
            phoneNumber.setText("로그인 후 확인가능합니다");
            phoneNumber.setEnabled(false);
            birthDayEditText.setText("로그인 후 확인가능합니다");
            birthDayEditText.setEnabled(false);
            addressEditText.setText("로그인 후 확인가능합니다");
            addressEditText.setEnabled(false);


            logincheckBtn.setText("로그인하기");
            logincheckBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //로그인 성공시 현재 프라그먼트 종료후 새로고침
                    getActivity().finish();
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);

                }
            });

        }
        //로그인 되어있을시 ,
        if(user != null){

            IdEditText.setText("파이어베이스에서 가져올 Data 부분 (아직안함)");
            IdEditText.setEnabled(false);
            phoneNumber.setText("파이어베이스에서 가져올 Data 부분 (아직안함)");
            phoneNumber.setEnabled(false);
            birthDayEditText.setText("파이어베이스에서 가져올 Data 부분 (아직안함)");
            birthDayEditText.setEnabled(false);
            addressEditText.setText("파이어베이스에서 가져올 Data 부분 (아직안함)");
            addressEditText.setEnabled(false);



            logincheckBtn.setText("로그아웃하기");
            logincheckBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseAuth.getInstance().signOut();
                }
            });
        }

        return rootview;
    }



    private void StartMyActivity(Class c){
        Intent intent = new Intent(getActivity(), c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

}
