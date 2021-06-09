package com.tennessee.project_navi;


import android.app.Activity;
import android.provider.ContactsContract;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
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

        GalleryViewHolder(Activity activity, CardView v, WriteInfo writeInfo) {
            super(v);
            cardView = v;

            LinearLayout contentsLayout = cardView.findViewById(R.id.contentsLayout);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            ArrayList<String> contentsList = writeInfo.getContents();

            if (contentsLayout.getChildCount() == 0) {
                for (int i = 0; i < contentsList.size(); i++) {
                    String contents = contentsList.get(i);
                    if (Patterns.WEB_URL.matcher(contents).matches()) {
                        ImageView imageView = new ImageView(activity);
                        imageView.setLayoutParams(layoutParams);
                        contentsLayout.addView(imageView);
                    } else {
                        TextView textView = new TextView(activity);
                        textView.setLayoutParams(layoutParams);
                        contentsLayout.addView(textView);
                    }
                }
            }
        }
    }

    public FeedAdapter(Activity activity, ArrayList<WriteInfo> myDataset) {
        mDataset = myDataset;
        this.activity = activity;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public FeedAdapter.GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false);
        final GalleryViewHolder vh = new GalleryViewHolder(activity, cardView, mDataset.get(viewType));
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cardView.findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });

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
        ArrayList<String> contentsList = mDataset.get(position).getContents();

        for (int i = 0; i < contentsList.size(); i++) {
            String contents = contentsList.get(i);
            if (Patterns.WEB_URL.matcher(contents).matches()) {
                Glide.with(activity).load(contents).override(800).thumbnail(0.1f).into((ImageView) contentsLayout.getChildAt(i));
            } else {

                ((TextView) contentsLayout.getChildAt(i)).setText(contents);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    private void showPopup(View v) {
        PopupMenu popup = new PopupMenu(activity, v);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.modify:
                        //myStartActivity(WritePostActivity.class, mDataset.get(position));
                        return true;
                    case R.id.delete:
                        //firebaseHelper.storageDelete(mDataset.get(position));
                        return true;
                    default:
                        return false;
                }
            }
        });
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.feed, popup.getMenu());
        popup.show();
    }
}
