package com.example.techer.MainMenuP;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.techer.InformationPages.*;
import com.example.techer.LevelPages.*;
import com.example.techer.MainMenu;
import com.example.techer.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class HardwarePage extends AppCompatActivity implements View.OnClickListener {


    public Button comp1Info;
    public Button comp2Info;
    public Button comp3Info;
    public Button comp4Info;
    public Button comp5Info;
    public Button comp6Info;
    public Button comp7Info;
    public Button comp8Info;
    public Button comp9Info;
    public Button tryInfo;
    public Button backButton;
    public Dialog dialog;
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware_page);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Users");
        mAuth = FirebaseAuth.getInstance();

        dialog = new Dialog(this);
        comp1Info = findViewById(R.id.MonitorInfo);
        comp2Info = findViewById(R.id.MotherboardInfo);
        comp3Info = findViewById(R.id.CPUInfo);
        comp4Info = findViewById(R.id.comp4Info);
        comp5Info = findViewById(R.id.Comps5Info);
        comp6Info = findViewById(R.id.Comps6Info);
        comp7Info = findViewById(R.id.Comps7Info);
        comp8Info = findViewById(R.id.Comps8Info);
        comp9Info = findViewById(R.id.Comps9Info);
        tryInfo = findViewById(R.id.tryInfo);
        backButton = findViewById(R.id.backButton);

        comp1Info.setOnClickListener(this);
        comp2Info.setOnClickListener(this);
        comp3Info.setOnClickListener(this);
        comp4Info.setOnClickListener(this);
        comp5Info.setOnClickListener(this);
        comp6Info.setOnClickListener(this);
        comp7Info.setOnClickListener(this);
        comp8Info.setOnClickListener(this);
        comp9Info.setOnClickListener(this);
        tryInfo.setOnClickListener(this);
        backButton.setOnClickListener(this);

        Query query = reference.orderByChild("email").equalTo(mAuth.getCurrentUser().getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()){
                    boolean firstTimeHardware = (boolean) ds.child("firstTimeHardware").getValue();
                    if(firstTimeHardware){
                        startDialog();
                        reference.child(mAuth.getCurrentUser().getUid()).child("firstTimeHardware").setValue(false);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void startDialog(){
        dialog.setContentView(R.layout.hardware_first_info);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView imageViewClosed = dialog.findViewById(R.id.imageViewClose);
        Button btnOk = dialog.findViewById(R.id.btnOK);

        imageViewClosed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.MonitorInfo) {
            Intent intent = new Intent(this, monitor_information.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.MotherboardInfo) {
            Intent intent = new Intent(this, motherboard_information.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.CPUInfo) {
            Intent intent = new Intent(this, cpu_information.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.comp4Info) {
            Intent intent = new Intent(this, ram_information.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.Comps5Info) {
            Intent intent = new Intent(this, expansioncards_information.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.Comps6Info) {
            Intent intent = new Intent(this, powersupplyunit_information.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.Comps7Info) {
            Intent intent = new Intent(this, opticaldiscdrive_information.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.Comps8Info) {
            Intent intent = new Intent(this, harddiskdrive_information.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.Comps9Info) {
            Intent intent = new Intent(this, keyboardmouse_information.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.backButton){
            startActivity(new Intent(getApplicationContext(), MainMenu.class));
        }

       if (v.getId() == R.id.tryInfo) {
            Intent intent = new Intent(this, TryPage.class);
            startActivity(intent);
        }
    }
}