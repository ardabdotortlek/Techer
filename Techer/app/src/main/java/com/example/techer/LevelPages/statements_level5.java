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

import com.example.techer.MainMenuP.JavaPage;
import com.example.techer.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class statements_level5 extends AppCompatActivity implements View.OnClickListener {
    TextView level;
    TextView question;
    TextView questionBar;
    Button choice1;
    Button choice2;
    Button choice3;
    Button choice4;
    Button backButton;
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
        questionC.setTheQuestion("What would be the output of this code ? \n" +
                "public static void main(String s[])\n" +
                "    {\n" +
                "        int a = 7 * 3 + 6 / 2 - 5;\n" +
                "        int b = 21 - 8 + a % 3 * 11;\n" +
                "\n" +
                "        if(a < b)\n" +
                "        {\n" +
                "            System.out.println(\"A is less than B\");\n" +
                "        }\n" +
                "\n" +
                "        if(a = b)\n" +
                "        {\n" +
                "            System.out.println(\"A is equal to B\");\n" +
                "        }\n" +
                "\n" +
                "        if(a > b)\n" +
                "        {\n" +
                "            System.out.println(\"A is greater than B\");\n" +
                "        }\n" +
                "    }                                    ");
        questionC.setAnswer1("a is less than b");
        questionC.setAnswer2(" a is equal to b");
        questionC.setAnswer3("a is greater than b");
        questionC.setRightAnswer("compilation error");


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
        level.setText("Statements - Level 5");
        question.setText(questionC.getTheQuestion());

        startDialog();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.choice1){
            if (choice1.getText() == questionC.getRightAnswer()) {
                reference.child(mAuth.getCurrentUser().getUid()).child("3rowSoftwareQuestions").child("question5").setValue(true);
                reference.child(mAuth.getCurrentUser().getUid()).child("SoftwareAchievement3").setValue(true);
                openWinDialog();
            }
            else
                openLoseDialog();
        }


        if (v.getId() == R.id.choice2){
            if (choice2.getText() == questionC.getRightAnswer()){
                reference.child(mAuth.getCurrentUser().getUid()).child("3rowSoftwareQuestions").child("question5").setValue(true);
                reference.child(mAuth.getCurrentUser().getUid()).child("SoftwareAchievement3").setValue(true);
                openWinDialog();
            }
            else
                openLoseDialog();
        }

        if (v.getId() == R.id.choice3){
            if (choice3.getText() == questionC.getRightAnswer()) {
                reference.child(mAuth.getCurrentUser().getUid()).child("3rowSoftwareQuestions").child("question5").setValue(true);
                reference.child(mAuth.getCurrentUser().getUid()).child("SoftwareAchievement3").setValue(true);
                openWinDialog();
            }
            else
                openLoseDialog();
        }

        if (v.getId() == R.id.choice4){
            if (choice4.getText() == questionC.getRightAnswer()) {
                reference.child(mAuth.getCurrentUser().getUid()).child("3rowSoftwareQuestions").child("question5").setValue(true);
                reference.child(mAuth.getCurrentUser().getUid()).child("SoftwareAchievement3").setValue(true);
                openWinDialog();
            }
            else
                openLoseDialog();
        }

        if (v.getId() == R.id.backButton){
            startActivity(new Intent(getApplicationContext(), JavaPage.class));
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
        dialog.setContentView(R.layout.java3_ach_layout);
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