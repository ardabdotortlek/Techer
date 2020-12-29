package com.example.techer.InformationPages;
import com.example.techer.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class temp_info extends AppCompatActivity {

    private TextView header;
    private TextView information;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_canvas);

        header = findViewById(R.id.infoTitle);
        information = findViewById(R.id.informationText);
        image = findViewById(R.id.imageInfo);

        header.setText("efehuso");
        information.setText("podfghsodfhgıousfhdgıofsds dfghsdfıghsoıfdgh soıfdghosıf dghsdofghsofdg hsdofgh oıfdgh sofdgh sdfogh sdfuhg sdfuhgsdfoıguhsdfgısfuhdsdfvuınsdfvoınfdvıou sndfıundsfıgonsdfıgusndfgndsfoıgnsdfıgousdfngoı");
        image.setBackgroundResource(R.drawable.ev_photo);

    }
}