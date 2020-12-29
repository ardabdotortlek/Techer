package com.example.techer.InformationPages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.techer.R;

public class expansioncards_information extends AppCompatActivity {

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
        header.setText("Expansion Cards");
        information.setText("expansion card, also known as an expansion board, adapter card or accessory card, is a printed circuit board that can be inserted into an electrical connector, or expansion slot, on a computer motherboard, backplane or riser card to add functionality to a computer system via the expansion bus.");
        image.setBackgroundResource(R.drawable.expcards);
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}