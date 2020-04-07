package com.example.teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.teacher.Adapter.Post;
import com.example.teacher.Adapter.Posterpost;
import com.example.teacher.Model.Posterpostm;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Posterprof extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;

    private RecyclerView recyclerView;
    private Posterpost posterpost;
    private List<Posterpostm> posterpostmList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posterprof);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("Poster").child("Posts");
        reference.keepSynced(true);

        recyclerView = (RecyclerView)findViewById(R.id.poster_posts_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        posterpostmList = new ArrayList<>();
        posterpost = new Posterpost(this,posterpostmList);
        recyclerView.setAdapter(posterpost);

        readPost();
    }
    private void readPost(){
        reference.keepSynced(true);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                posterpostmList.clear();
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    Posterpostm shopmodal = dataSnapshot1.getValue(Posterpostm.class);
                    posterpostmList.add(shopmodal);
                    posterpost.notifyDataSetChanged(); }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
