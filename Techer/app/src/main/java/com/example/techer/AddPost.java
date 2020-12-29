package com.example.techer;
/**
 * @author Arda Barış Örtlek
 */
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.HashMap;

public class AddPost extends AppCompatActivity {

    EditText title, description;
    Button uploadButton;
    FirebaseDatabase database;
    FirebaseAuth mAuth;
    DatabaseReference reference;
    String email,name,surname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        title = findViewById(R.id.Title);
        description = findViewById(R.id.Description);
        uploadButton = findViewById(R.id.upload);

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleForDatabase = title.getText().toString().trim();
                String descriptionForDatabase = description.getText().toString().trim();

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("Users");
                mAuth = FirebaseAuth.getInstance();
                Query query = reference.orderByChild("email").equalTo(mAuth.getCurrentUser().getEmail());
                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot ds: snapshot.getChildren()){
                            name = "" + ds.child("name").getValue();
                            surname = "" + ds.child("surname").getValue();
                            email = "" + ds.child("email").getValue();
                        }
                        if(TextUtils.isEmpty(titleForDatabase)){
                            Toast.makeText(AddPost.this, "Enter a title", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if(TextUtils.isEmpty(descriptionForDatabase)){
                            Toast.makeText(AddPost.this, "Enter a description", Toast.LENGTH_SHORT).show();
                        }

                        updatePost(titleForDatabase,descriptionForDatabase);
                        finish();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }

    private void updatePost(String title1, String description1){
        String timestamp = String.valueOf(System.currentTimeMillis());

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("userName",name);
        hashMap.put("userSurname", surname);
        hashMap.put("userEmail",email);
        hashMap.put("userTitle",title1);
        hashMap.put("userDescription",description1);
        hashMap.put("userTimestamp",timestamp);
        hashMap.put("userLikes","0");

        DatabaseReference ref = database.getReference("Posts");
        ref.child(timestamp).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(AddPost.this, "Post has been published", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AddPost.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        title.setText("");
        description.setText("");
    }
}