package com.example.teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.teacher.Adapter.Post;
import com.example.teacher.Model.Postm;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PostActivity extends AppCompatActivity {
private Toolbar toolbar;
    FirebaseDatabase database;
    DatabaseReference reference;

    private RecyclerView recyclerView;
    private Post post;
    private List<Postm> postmList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        toolbar = (Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("Poster").child("Posts");
        reference.keepSynced(true);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_post_post);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        postmList = new ArrayList<>();
        post = new Post(this,postmList);
        recyclerView.setAdapter(post);

        readPost();

    }
    private void readPost(){
        reference.keepSynced(true);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                postmList.clear();
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    Postm shopmodal = dataSnapshot1.getValue(Postm.class);
                    postmList.add(shopmodal);
                    post.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
