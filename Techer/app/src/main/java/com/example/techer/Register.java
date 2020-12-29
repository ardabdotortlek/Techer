package com.example.techer;
/**
 * @author Arda Barış Örtlek
 */

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Register extends AppCompatActivity {
    private EditText name, surname, email, password;
    private Button registerButton;
    private FirebaseAuth mAuth;
    private TextView loginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.mAuth = FirebaseAuth.getInstance();

        this.name = findViewById(R.id.Name);
        this.surname = findViewById(R.id.Surname);
        this.email = findViewById(R.id.eMail);
        this.password = findViewById(R.id.password);
        this.registerButton = findViewById(R.id.registorButton);
        this.loginText = findViewById(R.id.Login);

//        if(mAuth.getCurrentUser() != null){
//            startActivity(new Intent(getApplicationContext(),Login.class));
//            finish();
//        }


        this.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();

                if(TextUtils.isEmpty(Email)){
                    email.setError("Please enter an email");
                    return;
                }
                if(TextUtils.isEmpty(Password)){
                    password.setError("Please enter a password");
                    return;
                }

                if(Password.length() < 6){
                    password.setError("Password length must be greater than 5");
                    return;
                }

                //Register User
                mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user = mAuth.getCurrentUser();
                            String userMail = user.getEmail();
                            String uid = user.getUid();
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference reference = database.getReference("Users");
                            HashMap<String,Object> hashMap = new HashMap<>();
                            hashMap.put("email",email.getText().toString());
                            hashMap.put("name",name.getText().toString());
                            hashMap.put("surname",surname.getText().toString());
                            hashMap.put("SoftwareAchievement1",false);
                            hashMap.put("SoftwareAchievement2",false);
                            hashMap.put("SoftwareAchievement3",false);
                            hashMap.put("SoftwareAchievement4",false);
                            hashMap.put("SoftwareAchievement5",false);
                            hashMap.put("HardwareAchievement5",false);
                            hashMap.put("HardwareAchievement10",false);
                            hashMap.put("HardwareAchievement15",false);
                            hashMap.put("firstTimeMenu",true);
                            hashMap.put("firstTimeJava",true);
                            hashMap.put("firstTimeHardware",true);
                            reference.child(uid).setValue(hashMap);
                            HashMap<String,Object> hashMapForQuestions = new HashMap<>();
                            hashMapForQuestions.put("question1",false);
                            hashMapForQuestions.put("question2",false);
                            hashMapForQuestions.put("question3",false);
                            hashMapForQuestions.put("question4",false);
                            hashMapForQuestions.put("question5",false);
                            reference.child(uid).child("1rowSoftwareQuestions").setValue(hashMapForQuestions);
                            reference.child(uid).child("2rowSoftwareQuestions").setValue(hashMapForQuestions);
                            reference.child(uid).child("3rowSoftwareQuestions").setValue(hashMapForQuestions);
                            reference.child(uid).child("4rowSoftwareQuestions").setValue(hashMapForQuestions);
                            reference.child(uid).child("5rowSoftwareQuestions").setValue(hashMapForQuestions);

                            Toast.makeText(Register.this, "Account has been created successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Login.class));
                        }

                        else{
                            Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });
    }
}