package com.example.techer.InformationPages;
import com.example.techer.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class operations_information extends AppCompatActivity  {
    TextView informationText;
    Button backButton;
    ImageView image;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_canvas);
        informationText = findViewById(R.id.informationText);
        String para = "There are 5 types of operators in java\n" +
                "Arithmetic operators\n" +
                "+ addition , - subtraction , * multiplication , / division , % modulus , ++ increment , -- decrement  \n" +
                "\n" +
                "Assignment operators\n" +
                "= , += , -= , *= , /= , %= , &= , |= , ^= , >>= , <<= \n" +
                "\n" +
                "Comparison operators\n" +
                "== equal to , != not equal , > greater than , < less than , >= greater than or equal to , <= less than or equal to \n" +
                "\n" +
                "Logical operators\n" +
                "&& logical and , || logical or , ! logical not\n" +
                "\n" +
                "Bitwise operators\n" +
                "& , | , ~ , ^ , << , >> , >>>";

        informationText.setText(para);
        informationText.setMovementMethod(new ScrollingMovementMethod());

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        image = findViewById(R.id.imageInfo);
        image.setBackgroundResource(R.drawable.java_operators_new);

        title = findViewById(R.id.infoTitle);
        title.setText("Operations");
    }
}