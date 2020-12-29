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

public class loops_level2 extends AppCompatActivity implements View.OnClickListener {

    TextView questionBar;
    TextView questionText;
    TextView questionLevel;
    TextView submitArea;
    EditText editText;
    Button submit;
    String rightAnswer;
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

        dialog = new Dialog(this);
        submitArea = findViewById(R.id.submit_areaET);
        questionBar = findViewById(R.id.questionBarET);
        questionText = findViewById(R.id.questionTextET);
        questionLevel = findViewById(R.id.questionLevelET);
        editText = findViewById(R.id.editTextET);
        submit = findViewById(R.id.submitET);
        backButton = findViewById(R.id.backButton);

        rightAnswer = "j<16";

        questionText.setText("What must the test be so that the following fragment prints out the integers 5 through and including 15?\\n \\n\" +\n" +
                "                \"for ( int j = 5;  ____ ; j++ )\\n\" +\n" +
                "                \"{\\n\" +\n" +
                "                \"  System.out.print( j + \\\" \\\" );\\n\" +\n" +
                "                \"}\\n\" +\n" +
                "                \"System.out.println( Please enter the answer without spaces.);");


        submit.setOnClickListener(this);
        backButton.setOnClickListener(this);
        questionLevel.setText("Loops - Level 2");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submitET){
            int count = 0;
            for (int i = 0; i < rightAnswer.length() ; i++) {
                if (editText.getText().toString().trim().charAt(i) == rightAnswer.charAt(i)){
                    count++;
            }
            }
            if (count == rightAnswer.length()){
                reference.child(mAuth.getCurrentUser().getUid()).child("4rowSoftwareQuestions").child("question2").setValue(true);
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
                startActivity(new Intent(getApplicationContext(), loops_level3.class));
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