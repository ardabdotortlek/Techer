package com.example.techer;
/**
 * @author Arda Barış Örtlek
 */
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Forum extends AppCompatActivity {

    RecyclerView recyclerView;
    List<ModalPost> postList;
    AdapterPosts adapterPosts;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        button = findViewById(R.id.forumPostAdder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddPost.class));
            }
        });

        recyclerView = findViewById(R.id.postsRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);

        recyclerView.setLayoutManager(linearLayoutManager);

        postList = new ArrayList<>();
        loadPosts();


    }
    private void loadPosts(){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Posts");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                postList.clear();

                for(DataSnapshot ds: snapshot.getChildren()){
                    String name = "" + ds.child("userName").getValue();
                    String surname = "" + ds.child("userSurname").getValue();
                    String email = "" + ds.child("userEmail").getValue();
                    String title = "" + ds.child("userTitle").getValue();
                    String description = "" + ds.child("userDescription").getValue();
                    String timestamp = "" + ds.child("userTimestamp").getValue();
                    String userLikes = "" + ds.child("userLikes").getValue();

                    ModalPost modalPost = new ModalPost(name,surname,email,title,description,timestamp,userLikes);

                    postList.add(modalPost);

                    adapterPosts = new AdapterPosts(getApplicationContext(),postList);

                    recyclerView.setAdapter(adapterPosts);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}