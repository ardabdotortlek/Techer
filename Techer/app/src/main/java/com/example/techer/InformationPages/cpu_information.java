package com.example.techer.InformationPages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.techer.R;

public class cpu_information extends AppCompatActivity {

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
        information.setMovementMethod(new ScrollingMovementMethod());
        header.setText("CPU");
        information.setText("A central processing unit, or CPU, is a piece of hardware that enables your computer to interact with all of the applications and programs installed. A CPU interprets the program's instructions and creates the output that you interface with when you're using a computer.");
        image.setBackgroundResource(R.drawable.cpu);
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}