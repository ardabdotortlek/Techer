package com.example.techer.MainMenuP;
import com.example.techer.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class UserPage extends AppCompatActivity {
    Button backButton;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    ImageView image7;
    ImageView image8;
    TextView variable;
    TextView operations;
    TextView statements;
    TextView loops;
    TextView arrays;
    TextView fiveQuestion;
    TextView tenQuestion;
    TextView fifteenQuestion;
    TextView userName;
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Users");

        userName = findViewById(R.id.usernamePlaceholder);
        backButton = findViewById(R.id.backButton);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        variable = findViewById(R.id.achievement1);
        operations = findViewById(R.id.achievement2);
        statements = findViewById(R.id.achievement3);
        loops = findViewById(R.id.achievement4);
        arrays = findViewById(R.id.achievement5);
        fiveQuestion = findViewById(R.id.achievement6);
        tenQuestion = findViewById(R.id.achievement7);
        fifteenQuestion = findViewById(R.id.achievement8);

        Query query = reference.orderByChild("email").equalTo(mAuth.getCurrentUser().getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()){
                    String name = "" + ds.child("name").getValue();
                    String surname = "" + ds.child("surname").getValue();
                    userName.setText(name + " " + surname);
                    boolean soft1 = (boolean) ds.child("SoftwareAchievement1").getValue();
                    boolean soft2 = (boolean) ds.child("SoftwareAchievement2").getValue();
                    boolean soft3 = (boolean) ds.child("SoftwareAchievement3").getValue();
                    boolean soft4 = (boolean) ds.child("SoftwareAchievement4").getValue();
                    boolean soft5 = (boolean) ds.child("SoftwareAchievement5").getValue();
                    boolean hardw1 = (boolean) ds.child("HardwareAchievement5").getValue();
                    boolean hardw2 = (boolean) ds.child("HardwareAchievement10").getValue();
                    boolean hardw3 = (boolean) ds.child("HardwareAchievement15").getValue();

                    if(soft1){
                        image1.setVisibility(View.VISIBLE);
                        variable.setVisibility(View.VISIBLE);
                    }
                    else{
                        image1.setVisibility(View.INVISIBLE);
                        variable.setVisibility(View.INVISIBLE);
                    }

                    if(soft2){
                        image2.setVisibility(View.VISIBLE);
                        operations.setVisibility(View.VISIBLE);
                    }
                    else{
                        image2.setVisibility(View.INVISIBLE);
                        operations.setVisibility(View.INVISIBLE);
                    }

                    if(soft3){
                        image3.setVisibility(View.VISIBLE);
                        statements.setVisibility(View.VISIBLE);
                    }
                    else{
                        image3.setVisibility(View.INVISIBLE);
                        statements.setVisibility(View.INVISIBLE);
                    }

                    if(soft4){
                        image4.setVisibility(View.VISIBLE);
                        loops.setVisibility(View.VISIBLE);
                    }
                    else{
                        image4.setVisibility(View.INVISIBLE);
                        loops.setVisibility(View.INVISIBLE);
                    }

                    if(soft5){
                        image5.setVisibility(View.VISIBLE);
                        arrays.setVisibility(View.VISIBLE);
                    }
                    else{
                        image5.setVisibility(View.INVISIBLE);
                        arrays.setVisibility(View.INVISIBLE);
                    }
                    if(hardw1){
                        image6.setVisibility(View.VISIBLE);
                        fiveQuestion.setVisibility(View.VISIBLE);
                    }
                    else{
                        image6.setVisibility(View.INVISIBLE);
                        fiveQuestion.setVisibility(View.INVISIBLE);
                    }
                    if(hardw2){
                        image7.setVisibility(View.VISIBLE);
                        tenQuestion.setVisibility(View.VISIBLE);
                    }
                    else{
                        image7.setVisibility(View.INVISIBLE);
                        tenQuestion.setVisibility(View.INVISIBLE);
                    }
                    if(hardw3){
                        image8.setVisibility(View.VISIBLE);
                        fifteenQuestion.setVisibility(View.VISIBLE);
                    }
                    else{
                        image8.setVisibility(View.INVISIBLE);
                        fifteenQuestion.setVisibility(View.INVISIBLE);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}