package com.example.techer.InformationPages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.techer.R;

public class opticaldiscdrive_information extends AppCompatActivity {

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
        header.setText("Optical Disc Drive");
        information.setText("Optical disc drive (ODD) is a disc drive that uses laser light or electromagnetic waves within or near the visible light spectrum as part of the process of reading or writing data to or from optical discs. Some drives can only read from certain discs, but recent drives can both read and record, also called burners or writers (since they physically burn the organic dye on write-once CD-R, DVD-R and BD-R LTH discs). Compact discs, DVDs, and Blu-ray discs are common types of optical media which can be read and recorded by such drives");
        image.setBackgroundResource(R.drawable.odd);
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}