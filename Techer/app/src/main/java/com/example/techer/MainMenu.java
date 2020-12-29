package com.example.techer;
import com.example.techer.InformationPages.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.techer.MainMenuP.CreditsPage;
import com.example.techer.MainMenuP.HardwarePage;
import com.example.techer.MainMenuP.JavaPage;
import com.example.techer.MainMenuP.UserPage;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {
    public Button java;
    public Button hardware;
    public Button personalPage;
    public Button forum;
    public Button credits;
    public Button logout;
    public TextView username;
    public Dialog dialog;
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseAuth mAuth;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Users");
        setContentView(R.layout.activity_main_menu2);
        dialog = new Dialog(this);
        java = findViewById(R.id.javaButton);
        hardware = findViewById(R.id.hardwareButton);
        personalPage = findViewById(R.id.personaPage);
        forum = findViewById(R.id.forumPage);
        credits = findViewById(R.id.creditsButton);
        username = findViewById(R.id.usernameDisplay);
        logout = findViewById(R.id.logoutButton);

        java.setOnClickListener(this);
        hardware.setOnClickListener(this);
        personalPage.setOnClickListener(this);
        forum.setOnClickListener(this);
        credits.setOnClickListener(this);
        logout.setOnClickListener(this);

        Intent intent = getIntent();
        Query query = reference.orderByChild("email").equalTo(mAuth.getCurrentUser().getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()){
                    boolean firstTimeMenu = (boolean) ds.child("firstTimeMenu").getValue();
                    String name = "" + ds.child("name").getValue();
                    String surname = "" + ds.child("surname").getValue();
                    username.setText("Welcome: " + name + " " + surname);

                    if(firstTimeMenu){
                        startDialog();
                        reference.child(mAuth.getCurrentUser().getUid()).child("firstTimeMenu").setValue(false);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




       

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.javaButton) {
            Intent intent = new Intent(this, JavaPage.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.hardwareButton){
            Intent intent = new Intent(this, HardwarePage.class );
            startActivity(intent);
        }

        if (v.getId() == R.id.personaPage){
            Intent intent = new Intent(this, UserPage.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.forumPage){
            Intent intent = new Intent(this,Forum.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.creditsButton){
            Intent intent = new Intent(this, CreditsPage.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.logoutButton){
            mAuth.signOut();
            startActivity(new Intent(getApplicationContext(),Register.class));
        }


    }

    public void startDialog(){
        dialog.setContentView(R.layout.welcome_techer_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewClosed = dialog.findViewById(R.id.imageViewClose);
        Button btnOk = dialog.findViewById(R.id.btnOK);

        imageViewClosed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


}