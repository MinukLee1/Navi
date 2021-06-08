package com.tennessee.project_navi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FeedFragment extends Fragment {

    FloatingActionButton floatingBtn;

    private Context context;

    public FeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = container.getContext();
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.feed_fragment,container,false);

        floatingBtn = rootview.findViewById(R.id.floatingActionButton);
        // Inflate the layout for this fragment
        //게시글 작성버튼
        //로그인이 안되어있을시 ,
        if (user == null) {
            floatingBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "로그인 후 글 작성이 가능합니다", Toast.LENGTH_LONG).show();
                }
            });
        }
        //로그인 되어있을시 ,
        if (user != null) {

            floatingBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), WritePostActivity.class);
                    startActivity(intent);
                }
            });
        }
        return rootview;
    }
}