package com.example.teacher;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.teacher.Adapter.Post;
import com.example.teacher.Model.Postm;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Socialfrag extends Fragment {
   private Toolbar toolbar;
   FirebaseDatabase database;
   DatabaseReference reference;

   LinearLayout linearLayout;

   private RecyclerView recyclerView;
   private Post post;
   private List<Postm> postmList;

    public Socialfrag() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_socialfrag,container,false);

        toolbar = view.findViewById(R.id.social_tool);
        toolbar.setTitle("");
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);

//        linearLayout=(LinearLayout) view.findViewById(R.id.profile_frag);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("Poster").child("Posts");
        reference.keepSynced(true);

        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_post);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        postmList = new ArrayList<>();
        post = new Post(getContext(),postmList);
        recyclerView.setAdapter(post);

//        linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
//                ft.replace(R.id.container,new Posterfragprof());
//                ft.commit();
//            }
//        });
        readPost();

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.tool_social_menu,menu);
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
