package com.example.techer.LevelPages;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.techer.R;

public class TryPage extends AppCompatActivity implements View.OnClickListener {
    public Button ch1;
    public Button ch2;
    public Button ch3;
    public Button backButton;

    private boolean choose1 = false;
    private boolean choose2 = false;


    public boolean getChoose1(){
        return this.choose1;
    }

    public boolean getChoose2(){
        return this.choose2;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_page);

        ch1 = findViewById(R.id.FiveQuestion);
        ch2 = findViewById(R.id.TenQuestion);
        ch3 = findViewById(R.id.FifteenQuestion);
        backButton = findViewById(R.id.backButton);

        Intent intent = getIntent();

        ch1.setText("Beginner");
        ch2.setText("Medium");
        ch3.setText("Expert");
        ch1.setOnClickListener(this);
        ch2.setOnClickListener(this);
        ch3.setOnClickListener(this);
        backButton.setOnClickListener(this);




    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.FiveQuestion) {
            choose1 = false;
            choose2 = false;
            Intent intent = new Intent(this, hardware_question1.class);
            startActivity(intent);

        }

        if (v.getId() == R.id.TenQuestion) {
            choose1 = true;
            choose2 = false;
            Intent intent = new Intent(this, hardware_question6.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.FifteenQuestion){
            choose1 = true;
            choose2 = true;
            Intent intent = new Intent(this, hardware_question11.class );
            startActivity(intent);
        }

        if (v.getId() == R.id.backButton){
            finish();
        }
    }

}