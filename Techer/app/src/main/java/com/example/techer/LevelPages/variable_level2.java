package com.example.techer.LevelPages;
import com.example.techer.*;
import com.example.techer.MainMenuP.JavaPage;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class variable_level2 extends AppCompatActivity implements View.OnClickListener {
     TextView questionBar;
     Button trueButton;
     Button falseButton;
     TextView question;
     TextView level;
     Button backButton;
     Dialog dialog;
     FirebaseDatabase database;
     DatabaseReference reference;
     FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_true_false);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Users");
        mAuth = FirebaseAuth.getInstance();

        questionBar = findViewById(R.id.questionBarTF);
        trueButton = findViewById(R.id.trueOption);
        falseButton = findViewById(R.id.falseOption);
        question = findViewById(R.id.questionTF);
        level = findViewById(R.id.questionLevelTF);
        backButton = findViewById(R.id.backButton);

        question.setText("Long data type corresponds to 16 bit");
        level.setText("Variables - Level 2");

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
        dialog = new Dialog(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.trueOption){
            reference.child(mAuth.getCurrentUser().getUid()).child("1rowSoftwareQuestions").child("question2").setValue(true);
            openWinDialog();
        }

        if (v.getId() == R.id.falseOption){
            openLoseDialog();
        }

        if (v.getId() == R.id.backButton)
            startActivity(new Intent(getApplicationContext(), JavaPage.class));
    }

    private void openWinDialog() {
        dialog.setContentView(R.layout.win_layout_dialog);
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
                startActivity(new Intent(getApplicationContext(), variable_level3.class));
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void openLoseDialog() {
        dialog.setContentView(R.layout.lose_layout_dialog);
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
                startActivity(new Intent(getApplicationContext(), JavaPage.class));
                dialog.dismiss();

            }
        });

        dialog.show();
    }
}