package com.tennessee.project_navi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class BookmarkFragment extends Fragment {

    EditText text3;
    public BookmarkFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.bookmark_fragment,container,false);
        text3 = rootview.findViewById(R.id.text3);
       /* View v = inflater.inflate(R.layout.bookmark_fragment, container, false);
        text = v.findViewById(R.id.text3);*/
        //text3.setText(BookmarkFragment_kt.formatMessage("Android with kotlin"));
        /*text31.setText("로그인 후 확인가능합니다");
        text31.setEnabled(false);*/
        return rootview;
    }
}