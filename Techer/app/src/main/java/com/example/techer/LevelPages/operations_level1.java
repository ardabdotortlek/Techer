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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.techer.LevelPages.Question;
import com.example.techer.MainMenuP.JavaPage;
import com.example.techer.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class operations_level1 extends AppCompatActivity implements View.OnClickListener {

    TextView questionBar;
    TextView questionText;
    TextView questionLevel;
    TextView submitArea;
    EditText editText;
    Button submit;
    int rightAnswer;
    Button backButton;
    Dialog dialog;
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseAuth mAuth;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.question_edittext);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Users");
        mAuth = FirebaseAuth.getInstance();
        dialog  = new Dialog(this);
        submitArea = findViewById(R.id.submit_areaET);
        questionBar = findViewById(R.id.questionBarET);
        questionText = findViewById(R.id.questionTextET);
        questionLevel = findViewById(R.id.questionLevelET);
        editText = findViewById(R.id.editTextET);
        submit = findViewById(R.id.submitET);
        backButton = findViewById(R.id.backButton);

        questionLevel.setText("Operations - Level 1");
        rightAnswer = 16;

        questionText.setText("What will be the output of the following program?\\n\" +\n" +
                "                        \"class MyClass {\\n\" +\n" +
                "                        \"\\t public static void main(String[] args) {\\n\"+\n" +
                "                        \"\\t \\t int i = 4;\\n\" +\n" +
                "                        \"\\t \\t int j = 21;\\n\" +\n" +
                "                        \"\\t \\t int k = ++i * 7 + 2 - j--;\\n\" +\n" +
                "                        \"\\t \\t System.out.println(\\\"k = \\\" + k);\\n\" +\n" +
                "                        \"\\t \\t }\\n\" +\n" +
                "                        \"\\t }\\n\" +\n" +
                "                        \"}");


        submit.setOnClickListener(this);
        backButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submitET){
            if (Integer.parseInt(editText.getText().toString().trim()) == rightAnswer ){
                reference.child(mAuth.getCurrentUser().getUid()).child("2rowSoftwareQuestions").child("question1").setValue(true);
                openWinDialog();

            }
            else
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
                startActivity(new Intent(getApplicationContext(), operations_level2.class));
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