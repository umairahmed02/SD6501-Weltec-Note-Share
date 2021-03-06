package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.firestore.FirebaseFirestore;

public class Home extends AppCompatActivity {

    ImageView img_subject1, img_subject2, img_subject3, img_subject4;
    Button changeButton, deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        img_subject1 = findViewById(R.id.img_subject1);
        img_subject2 = findViewById(R.id.img_subject2);
        img_subject3 = findViewById(R.id.img_subject3);
        img_subject4 = findViewById(R.id.img_subject4);

        changeButton = findViewById(R.id.change_password);
        deleteButton = findViewById(R.id.delete_account);

        img_subject1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Subject1.class);
                startActivity(intent);
            }
        });

        img_subject2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Subject2.class);
                startActivity(intent);
            }
        });

        img_subject3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Subject3.class);
                startActivity(intent);
            }
        });

        img_subject4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Subject4.class);
                startActivity(intent);
            }
        });

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, ChangePassword.class);
                startActivity(intent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("User").document(User.getInstance("u", "p", "e").username).delete();
                Intent intent = new Intent(Home.this, StartScreen.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            Intent intent = new Intent(Home.this, StartScreen.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}