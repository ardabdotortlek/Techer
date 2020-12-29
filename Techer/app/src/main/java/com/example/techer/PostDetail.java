package com.example.techer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class PostDetail extends AppCompatActivity {
    //Fields
    TextView userPostName, userPostDate, userPostTitle, userPostLikes, userPostDislikes,userPostDescription;
    EditText commentText;
    Button sendButton;
    RecyclerView recyclerView;

    List<ModelComment> commentList;
    AdapterComments adapterComments;

    String myName, myEmail, postId, postLikes, postDislikes,postName;
    boolean mProcessLike = false;
    boolean mProcessDislike = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        Intent intent = getIntent();
        postId = intent.getStringExtra("userTimestamp");

        userPostName = findViewById(R.id.userPostName);
        userPostDate = findViewById(R.id.userPostDate);
        userPostTitle = findViewById(R.id.userPostTitle);
        userPostLikes = findViewById(R.id.userPostLikes);
        userPostDescription = findViewById(R.id.userPostDescription);
        commentText = findViewById(R.id.commentText);
        sendButton = findViewById(R.id.sendButton);
        recyclerView = findViewById(R.id.recyclerView);

        loadPostInfo();
        myEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        loadUserInfo();

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postComment();
            }
        });

        loadComments();
    }

    private void loadComments(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        commentList = new ArrayList<>();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Posts").child(postId).child("Comments");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                commentList.clear();
                for(DataSnapshot ds: snapshot.getChildren()){
                    String name = "" + ds.child("uName").getValue();
                    String email = "" + ds.child("uEmail").getValue();
                    String timestamp = "" + ds.child("cTimestamp").getValue();
                    String cComment = "" + ds.child("comment").getValue();
                    String id = "" + ds.child("cId").getValue();
                    ModelComment modelComment = new ModelComment(id,timestamp,cComment,email,name);

                    commentList.add(modelComment);

                    adapterComments = new AdapterComments(getApplicationContext(), commentList);
                    recyclerView.setAdapter(adapterComments);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void postComment(){
        String comment = commentText.getText().toString().trim();

        if(TextUtils.isEmpty(comment)){
            Toast.makeText(this, "Comment is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        String timeStamp = String.valueOf(System.currentTimeMillis());

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Posts").child(postId).child("Comments");
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("cId",timeStamp);
        hashMap.put("comment",comment);
        hashMap.put("cTimestamp",timeStamp);
        hashMap.put("uName",myName);
        hashMap.put("uEmail",myEmail);

        reference.child(timeStamp).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(PostDetail.this, "Comment Added", Toast.LENGTH_SHORT).show();
                commentText.setText("");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PostDetail.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadPostInfo(){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Posts");
        Query query = reference.orderByChild("userTimestamp").equalTo(postId);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    postName = "" + ds.child("userName").getValue() + " " + ds.child("userSurname").getValue();
                    String pTitle = "" + ds.child("userTitle").getValue();
                    String pDescription = "" + ds.child("userDescription").getValue();
                    String pTimestamp = "" + ds.child("userTimestamp").getValue();
                    postLikes = "" + ds.child("userLikes").getValue();

                    Calendar calendar = Calendar.getInstance(Locale.getDefault());
                    calendar.setTimeInMillis(Long.parseLong(pTimestamp));
                    String pTime = DateFormat.format("dd/MM/yyyy hh:mm aa",calendar).toString();

                    userPostName.setText(postName);
                    userPostTitle.setText(pTitle);
                    userPostDate.setText(pTime);
                    userPostLikes.setText(postLikes + " Likes");
                    userPostDescription.setText(pDescription);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void loadUserInfo(){
        Query q = FirebaseDatabase.getInstance().getReference("Users");
        q.orderByChild("email").equalTo(FirebaseAuth.getInstance().getCurrentUser().getEmail()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()){
                    myName = "" + ds.child("name").getValue() + " " + ds.child("surname").getValue();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}