package com.example.techer.InformationPages;
import com.example.techer.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class loops_information extends AppCompatActivity  {
    TextView informationText;
    Button backButton;
    ImageView image;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_canvas);
        informationText = findViewById(R.id.informationText);
        String para = "Loops can execute a block of code as long as a specified condition is reached.\n" +
                "\n" +
                "Loops are handy because they save time, reduce errors, and they make code more readable.\n" +
                "\n" +
                "The while loop loops through a block of code as long as a specified condition is true:\n" +
                "Syntax:\n" +
                "while (condition) {\n" +
                "  // code block to be executed\n" +
                "}\n" +
                "\n" +
                "The do/while loop is a variant of the while loop. This loop will execute the code block once,\n" +
                "before checking if the condition is true, then it will repeat the loop as long as the condition is true.\n" +
                "Syntax : \n" +
                "do {\n" +
                "  // code block to be executed\n" +
                "}\n" +
                "while (condition);\n" +
                "\n" +
                "The differences between while and do/while loop is in the do/while, loop must be launch at least one time and\n" +
                "the condition is checked after that.\n" +
                "\n" +
                "When you know exactly how many times you want to loop through a block of code, use the for loop instead of a while loop:\n" +
                "Syntax:\n" +
                "for (statement 1; statement 2; statement 3) {\n" +
                "  // code block to be executed\n" +
                "}\n" +
                "\n" +
                "For-Each Loop:\n" +
                "There is also a \"for-each\" loop, which is used exclusively to loop through elements in an array\n" +
                "Syntax:\n" +
                "for (type variableName : arrayName) {\n" +
                "  // code block to be executed";

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
        image.setBackgroundResource(R.drawable.loops_image);

        title = findViewById(R.id.infoTitle);
        title.setText("Loops");
    }
}