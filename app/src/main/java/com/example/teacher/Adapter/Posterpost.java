package com.example.teacher.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.teacher.Model.Posterpostm;
import com.example.teacher.PostActivity;
import com.example.teacher.Posterprof;
import com.example.teacher.R;

import java.util.List;

public class Posterpost extends RecyclerView.Adapter<Posterpost.ViewHolder> {
public Context mContext;
public List<Posterpostm> posterpostmList;

    public Posterpost(Context mContext, List<Posterpostm> posterpostmList) {
        this.mContext = mContext;
        this.posterpostmList = posterpostmList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_post_list,parent,false);

        return new Posterpost.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Posterpostm posterpostm = posterpostmList.get(position);
        if (posterpostm.getImagepost().equals("null") && posterpostm.getVideopost().equals("null")){
            holder.textView.setVisibility(View.VISIBLE);
            holder.videoView.setVisibility(View.GONE);
            holder.imageView.setVisibility(View.GONE);
            holder.textView.setText(posterpostm.getTextpost());

        }
        else if (posterpostm.getImagepost().equals("null") && posterpostm.getTextpost().equals("null")){
            holder.textView.setVisibility(View.GONE);
            holder.videoView.setVisibility(View.VISIBLE);
            holder.imageView.setVisibility(View.GONE);
            holder.videoView.setVideoURI(Uri.parse(posterpostm.getVideopost()));
            MediaController mediaController = new MediaController(mContext);
            holder.videoView.setMediaController(mediaController);
            holder.videoView.seekTo(100);
            mediaController.setAnchorView(holder.videoView);
            holder.videoView.start();
        }
        else if (posterpostm.getVideopost().equals("null") && posterpostm.getTextpost().equals("null")){
            holder.textView.setVisibility(View.GONE);
            holder.videoView.setVisibility(View.GONE);
            holder.imageView.setVisibility(View.VISIBLE);

            Glide.with(mContext).load(posterpostm.getImagepost()).into(holder.imageView);

        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PostActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posterpostmList.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
        public VideoView videoView;
        public CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_post);
            imageView = itemView.findViewById(R.id.image_post);
            videoView = itemView.findViewById(R.id.video_post);

            cardView = itemView.findViewById(R.id.post_card);


        }
    }

}
