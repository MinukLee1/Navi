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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MypageFragment extends Fragment {

Button logincheckBtn;


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
        logincheckBtn = rootview.findViewById(R.id.logincheckBtn);

        //로그인 안되어있을시 ,
        if(user == null) {
            logincheckBtn.setText("로그인하기");
            logincheckBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            });

        }
        //로그인 되어있을시 ,
        if(user != null){
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
