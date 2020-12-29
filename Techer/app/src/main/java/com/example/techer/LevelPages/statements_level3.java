package com.example.techer.LevelPages;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.techer.LevelPages.Question;
import com.example.techer.MainMenuP.JavaPage;
import com.example.techer.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class statements_level3 extends AppCompatActivity implements View.OnClickListener {

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
        dialog = new Dialog(this);
        submitArea = findViewById(R.id.submit_areaET);
        questionBar = findViewById(R.id.questionBarET);
        questionText = findViewById(R.id.questionTextET);
        questionLevel = findViewById(R.id.questionLevelET);
        editText = findViewById(R.id.editTextET);
        submit = findViewById(R.id.submitET);
        backButton = findViewById(R.id.backButton);

        rightAnswer = 2;

        questionText.setText("What will be the output of the following program?\\n\" +\n" +
                "class selection_statements \\n\" +\n" +
                "        \"{ \\n\" +\n" +
                "            \"\\t public static void main(String args[]) \\n\"  +\n" +
                "            \"{ \\n\" +\n" +
                "                \"\\t int var1 = 5; \\n\" +\n" +
                "                \"\\t int var2 = 6; \\n\" +\n" +
                "                \"\\t if ((var2 = 1) == var1) \\n\" +\n" +
                "                    \"\\t\\t System.out.print(var2); \\n\" +\n" +
                "                \"\\t else \\n\" +\n" +
                "                    \" \\t\\tSystem.out.print(++var2);\\n");


        submit.setOnClickListener(this);
        backButton.setOnClickListener(this);
        questionLevel.setText("Statements - Level 3");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submitET){
            if (Integer.parseInt(editText.getText().toString().trim()) == rightAnswer ){
                reference.child(mAuth.getCurrentUser().getUid()).child("3rowSoftwareQuestions").child("question3").setValue(true);
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
                startActivity(new Intent(getApplicationContext(), statements_level4.class));
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