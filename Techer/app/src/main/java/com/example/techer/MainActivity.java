package com.example.techer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;
//this class will be deleted later
// temporary login page
public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.example.techer.EXTRA_NAME";
    private EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button =(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

    }

    public void openActivity2(){
        username = findViewById(R.id.userName);
        String text = username.getText().toString();
        Intent intent = new Intent(this, MainMenu.class);
        intent.putExtra(EXTRA_NAME, text);
        startActivity(intent);
    }






}