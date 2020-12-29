package com.example.techer.LevelPages;
import com.example.techer.*;
import com.example.techer.MainMenuP.JavaPage;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class arrays_level5 extends AppCompatActivity implements View.OnClickListener {
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

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_true_false);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Users");
        mAuth = FirebaseAuth.getInstance();

        dialog = new Dialog(this);
        questionBar = findViewById(R.id.questionBarTF);
        trueButton = findViewById(R.id.trueOption);
        falseButton = findViewById(R.id.falseOption);
        question = findViewById(R.id.questionTF);
        level = findViewById(R.id.questionLevelTF);
        backButton = findViewById(R.id.backButton);
        trueButton.setText("Same");
        falseButton.setText("Not same");

        question.setText("What will be the output of following program ? \n" +
                "class Test\n" +
                "{\n" +
                "    public static void main (String[] args) \n" +
                "    {\n" +
                "        int arr1[] = {1, 2, 3};\n" +
                "        int arr2[] = {1, 2, 3};\n" +
                "        if (arr1 == arr2) \n" +
                "            System.out.println(\"Same\");\n" +
                "        else\n" +
                "            System.out.println(\"Not same\");\n" +
                "    }\n" +
                "}");
        level.setText("Arrays - Level 5");

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        backButton.setOnClickListener(this);


        startDialog();


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.trueOption){
            openLoseDialog();
        }

        if (v.getId() == R.id.falseOption){
            reference.child(mAuth.getCurrentUser().getUid()).child("5rowSoftwareQuestions").child("question5").setValue(true);
            reference.child(mAuth.getCurrentUser().getUid()).child("SoftwareAchievement5").setValue(true);
            openWinDialog();
        }

        if (v.getId() == R.id.backButton)
            startActivity(new Intent(getApplicationContext(), JavaPage.class));
    }



    private void startDialog(){
        dialog.setContentView(R.layout.achievement_question_layout);
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
    private void openWinDialog() {
        dialog.setContentView(R.layout.java5_ach_layout);
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