package com.example.techer.InformationPages;
import com.example.techer.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class statement_information extends AppCompatActivity  {
    TextView informationText;
    Button backButton;
    ImageView image;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_canvas);
        informationText = findViewById(R.id.informationText);
        String para = "Use if to specify a block of code to be executed, if a specified condition is true\n" +
                "Use else to specify a block of code to be executed, if the same condition is false\n" +
                "Use else if to specify a new condition to test, if the first condition is false\n" +
                "Use switch to specify many alternative blocks of code to be executed\n" +
                "\n" +
                "#example#\n" +
                "int time = 20;\n" +
                "if (time < 18) {\n" +
                "  System.out.println(\"Good day.\");\n" +
                "} else {\n" +
                "  System.out.println(\"Good evening.\");\n" +
                "}\n" +
                "// Outputs \"Good evening.\n" +
                "\n" +
                "#Example explained#\n" +
                "In the example above, time (20) is greater than 18, so the condition is false.\n" +
                " Because of this, we move on to the else condition and print to the screen \n" +
                "\"Good evening\". If the time was less than 18, the program would print \"Good day\".\n" +
                "\n" +
                "#example2#\n" +
                "\n" +
                "int time = 22;\n" +
                "if (time < 10) {\n" +
                "  System.out.println(\"Good morning.\");\n" +
                "} else if (time < 20) {\n" +
                "  System.out.println(\"Good day.\");\n" +
                "} else {\n" +
                "  System.out.println(\"Good evening.\");\n" +
                "}\n" +
                "// Outputs \"Good evening.\"\n" +
                "\n" +
                "#Example explained#\n" +
                "\n" +
                "In the example above, time (22) is greater than 10, so the first condition is false.\n" +
                " The next condition, in the else if statement, is also false, so we move on to the \n" +
                "else condition since condition1 and condition2 is both false - and print to the screen\n" +
                "\"Good evening\".\n" +
                "\n" +
                "However, if the time was 14, our program would print \"Good day.\"";

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
        image.setBackgroundResource(R.drawable.final_statements);

        title = findViewById(R.id.infoTitle);
        title.setText("Statements");
    }
}