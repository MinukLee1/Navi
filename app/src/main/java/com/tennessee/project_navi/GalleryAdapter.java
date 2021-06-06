package com.tennessee.project_navi;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class GalleryAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDatest;

public static class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView = textView;
    public MyViewHolder(TextView v){
        super(v);
        textView = v;
    }
}

public GalleryAdapter(String[] myDataset){
    myDataset = myDataset;
}

@Override
    public GalleryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
    TextView v = (TextView) LayoutInflater.from(parent.getContext())
            .inflate(R.layout.my_test_view.parent.false);
    MyViewHolder vh= new MyViewHolder(v);
    return vh;

}

@Override
    public void onBindViewHolder(MyViewHolder holder, int position){
    holder.textView.setText(mDatest[position]);
}


@Override
    public int getItemCount(){
return mDatest.length;
}
}
