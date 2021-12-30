package com.tennessee.project_navi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment

//fun formatMessage(name: String): String = "Hello, $name"

class BookmarkFragment_kt : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.bookmark_fragment,container,false)
        return view;




    }


}