package com.example.techer.InformationPages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.techer.R;

public class ram_information extends AppCompatActivity {

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

            header.setText("Main Memory(RAM)");
            information.setText("RAM stands for Random Access Memory. The data stored in RAM can be accessed almost instantly regardless of where in memory it is stored, so it's very fast — milliseconds fast. RAM has a very fast path to the computer's CPU, or central processing unit, the brain of the computer that does most of the work.");
            information.setMovementMethod(new ScrollingMovementMethod());
            image.setBackgroundResource(R.drawable.ram);
            backButton = findViewById(R.id.backButton);
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        }

}