package com.tennessee.project_navi;


import android.app.Activity;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.GalleryViewHolder> {
    private ArrayList<WriteInfo> mDataset;
    private Activity activity;

     static class GalleryViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        GalleryViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public FeedAdapter(Activity activity, ArrayList<WriteInfo> myDataset) {
        mDataset = myDataset;
        this.activity = activity;
    }
    @NonNull
    @Override
    public FeedAdapter.GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false);
        GalleryViewHolder vh = new GalleryViewHolder(v);
        return vh;
        }
    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        /*ImageView imageView = holder.cardView.findViewById(R.id.itemImage);
        Glide.with(activity).load(mDataset.get(position)).override(300).into(imageView);*/
        CardView cardView = holder.cardView;
        TextView titleTextView = cardView.findViewById(R.id.titleTextView);
        titleTextView.setText(mDataset.get(position).getTitle());

        TextView date = cardView.findViewById(R.id.dateTextView);
        date.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(mDataset.get(position).getDate()));

        LinearLayout contentsLayout = cardView.findViewById(R.id.contentsLayout);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ArrayList<String> contentsList = mDataset.get(position).getContents();

        for (int i = 0; i < contentsList.size(); i++){
            String contents = contentsList.get(i);
            if (Patterns.WEB_URL.matcher(contents).matches()){
                ImageView imageView = new ImageView(activity);
                imageView.setLayoutParams(layoutParams);
                contentsLayout.addView(imageView);
                Glide.with(activity).load(contents).override(1000).into(imageView);
            }else {
                TextView textView = new TextView(activity);
                textView.setLayoutParams(layoutParams);
                textView.setText(contents);
                contentsLayout.addView(textView);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
