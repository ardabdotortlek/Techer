package com.example.techer.LevelPages;

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

import com.example.techer.MainMenuP.HardwarePage;
import com.example.techer.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class hardware_question_final extends AppCompatActivity implements View.OnClickListener {
    TextView level;
    TextView question;
    TextView questionBar;
    Button choice1;
    Button choice2;
    Button choice3;
    Button choice4;
    Button backButton;
    TryPage tp = new TryPage();
    Dialog dialog;
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseAuth mAuth;

    Question questionC;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Users");
        mAuth = FirebaseAuth.getInstance();


        questionC = new Question();
        dialog = new Dialog(this);
        questionC.setTheQuestion("In order for a PC to function, it must have a _____ connected to the motherboard via a heat-sink, have sticks of _______ installed on the motherboard, be connected to a working ________ which gives the computer its electricity. It must also have a _________ to install the operating system on and to allow it to store and retrieve data.");
        questionC.setAnswer1("hard-drive, PSU, RAM, CPU");
        questionC.setAnswer2("CPU, hard-drive, PSU, RAM");
        questionC.setAnswer3("PSU, CPU, hard-drive, RAM");
        questionC.setRightAnswer("CPU, RAM, PSU, hard-drive");


        String[] answers = new String[4];
        answers[0] = questionC.getAnswer1();
        answers[1] = questionC.getAnswer2();
        answers[2] = questionC.getAnswer3();
        answers[3] = questionC.getRightAnswer();


        List<String> ansList = Arrays.asList(answers);
        Collections.shuffle(ansList);
        ansList.toArray(answers);


        setContentView(R.layout.question_canvas);

        level = findViewById(R.id.questionLevel);
        question = findViewById(R.id.question);
        questionBar = findViewById(R.id.questionBar);
        backButton = findViewById(R.id.backButton);

        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);
        choice4 = findViewById(R.id.choice4);

        choice1.setText(answers[0]);
        choice2.setText(answers[1]);
        choice3.setText(answers[2]);
        choice4.setText(answers[3]);

        choice1.setOnClickListener(this);
        choice2.setOnClickListener(this);
        choice3.setOnClickListener(this);
        choice4.setOnClickListener(this);

        backButton.setOnClickListener(this);


        questionBar.setText("");
        level.setText("Hardware Question 15");
        question.setText(questionC.getTheQuestion());

        if (!tp.getChoose1())
            startDialog();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.choice1){
            if (choice1.getText() == questionC.getRightAnswer()){
                reference.child(mAuth.getCurrentUser().getUid()).child("HardwareAchievement15").setValue(true);
                openWinDialog();
            }
            else
                openLoseDialog();
        }



        if (v.getId() == R.id.choice2){
            if (choice2.getText() == questionC.getRightAnswer()){
                reference.child(mAuth.getCurrentUser().getUid()).child("HardwareAchievement15").setValue(true);
                openWinDialog();
            }
            else
                openLoseDialog();
        }

        if (v.getId() == R.id.choice3){
            if (choice3.getText() == questionC.getRightAnswer()){
                reference.child(mAuth.getCurrentUser().getUid()).child("HardwareAchievement15").setValue(true);
                openWinDialog();
            }
            else
                openLoseDialog();

        }

        if (v.getId() == R.id.choice4){
            if (choice4.getText() == questionC.getRightAnswer()){
                reference.child(mAuth.getCurrentUser().getUid()).child("HardwareAchievement15").setValue(true);
                openWinDialog();
            }
            else
                openLoseDialog();
        }

        if (v.getId() == R.id.backButton){
            {
                startActivity(new Intent(getApplicationContext(), HardwarePage.class));
            }
        }

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
        dialog.setContentView(R.layout.hardware_ach_3);
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
                if (!tp.getChoose1()) {
                    startActivity(new Intent(getApplicationContext(), HardwarePage.class));
                    dialog.dismiss();
                }
                else
                    startActivity(new Intent(getApplicationContext(), hardware_question6.class));
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
                startActivity(new Intent(getApplicationContext(), HardwarePage.class));
                dialog.dismiss();

            }
        });

        dialog.show();
    }
}