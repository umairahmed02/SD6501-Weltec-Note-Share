package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class Signup extends AppCompatActivity {

    EditText username, password, passwordConfirm, email;
    ImageView img_signup;
    String user, pass, passConfirm, mail;
    int matches;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email = findViewById(R.id.txt_email);
        username = findViewById(R.id.txt_username);
        password = findViewById(R.id.txt_password);
        passwordConfirm = findViewById(R.id.txt_password_confirm);
        img_signup = findViewById(R.id.img_signup);

        getSupportActionBar().setTitle("Signup");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        img_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = username.getText().toString();
                pass = password.getText().toString();
                passConfirm = passwordConfirm.getText().toString();
                mail = email.getText().toString();

                if(user.length() < 5 && pass.length() < 8) {
                    Toast.makeText(Signup.this, "Username and Password not of sufficient length", Toast.LENGTH_SHORT).show();
                }
                else if(user.length() < 5) {
                    Toast.makeText(Signup.this, "Username is not of sufficient length", Toast.LENGTH_SHORT).show();
                }
                else if(pass.length() < 8) {
                    Toast.makeText(Signup.this, "Password is not of sufficient length", Toast.LENGTH_SHORT).show();
                }
                else if(passConfirm.length() < 8) {
                    Toast.makeText(Signup.this, "Confirm password is not of sufficient length", Toast.LENGTH_SHORT).show();
                }
                else if(!(pass.equals(passConfirm))) {
                    Toast.makeText(Signup.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
                else if(!(mail.contains("@"))) {
                    Toast.makeText(Signup.this, "Email is not valid", Toast.LENGTH_SHORT).show();
                }
                else{
                    matches = 0;
                    User newUser = new User(user, pass, mail);
                    db.collection("User").document(newUser.username).set(newUser);
                    Intent intent = new Intent(Signup.this, Home.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}