package com.example.teacher.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.teacher.Model.Postm;
import com.example.teacher.Posterprof;
import com.example.teacher.R;

import java.util.List;

public class Post extends RecyclerView.Adapter<Post.ViewHolder> {
    public Context mContext;
    public List<Postm> postmList;

    public Post(Context mContext, List<Postm> postmList) {
        this.mContext = mContext;
        this.postmList = postmList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_social_post,parent,false);
        return new Post.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Postm postm = postmList.get(position);

//        if (postm.getImagepost().equals("null") && postm.getVideopost().equals("null")){
//            holder.postText.setVisibility(View.VISIBLE);
//            holder.postImage.setVisibility(View.GONE);
//            holder.postVideo.setVisibility(View.GONE);
//            holder.postText.setText(postm.getTextpost());
//        }

        //holder.postername.setText(postm.getPostername());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Posterprof.class);

                (mContext).startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return postmList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView postername,postText;
        public ImageView postImage;
        public VideoView postVideo;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            postername = itemView.findViewById(R.id.poster_name);

            postText = itemView.findViewById(R.id.post_text);
            postImage = itemView.findViewById(R.id.image_post);
            postVideo = itemView.findViewById(R.id.video_post);

            linearLayout=itemView.findViewById(R.id.profile_frag);


        }
    }

}
