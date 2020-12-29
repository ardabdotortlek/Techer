package com.example.techer.InformationPages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.techer.R;

public class motherboard_information extends AppCompatActivity {

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

        header.setText("Motherboard");
        information.setText("The motherboard is the backbone that ties the computer's components together at one spot and allows them to talk to each other. Without it, none of the computer pieces, such as the CPU, GPU, or hard drive, could interact. Total motherboard functionality is necessary for a computer to work well.");
        image.setBackgroundResource(R.drawable.motherboard);
        backButton = findViewById(R.id.backButton);
        information.setMovementMethod(new ScrollingMovementMethod());


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}