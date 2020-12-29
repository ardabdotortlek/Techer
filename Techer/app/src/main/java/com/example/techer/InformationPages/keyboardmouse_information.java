package com.example.techer.InformationPages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.techer.R;

public class keyboardmouse_information extends AppCompatActivity {

    private TextView header;
    private TextView information;
    private ImageView image;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_canvas);

        header = findViewById(R.id.infoTitle);
        information = findViewById(R.id.informationText);
        image = findViewById(R.id.imageInfo);

        header.setText("Keyboard and Mouse");
        information.setText("Most interactions with a computer involve using a keyboard and a mouse. The keyboard allows the user to type letters and numbers and the mouse allows the user to position the cursor, draw and execute program functions by clicking mouse buttons.");
        header.setTextSize(30);
        information.setMovementMethod(new ScrollingMovementMethod());
        image.setBackgroundResource(R.drawable.keyboardmouse);
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}