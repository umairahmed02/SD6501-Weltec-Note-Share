package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NotePublish extends AppCompatActivity {

    EditText txtNote, txtTitle;
    Button btnPublish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_publish);

        getSupportActionBar().setTitle("New Note");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        txtNote = findViewById(R.id.txtBody);
        txtTitle = findViewById(R.id.txtTitle);
        btnPublish = findViewById(R.id.btnPublish);

        btnPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note note = new Note(txtNote.getText().toString(), txtTitle.getText().toString());
                Intent inboundIntent = getIntent();
                String activity = inboundIntent.getStringExtra("Activity");

                switch(activity) {
                    case "Subject1":
                        Intent outboundIntent = new Intent(NotePublish.this, Subject1.class);
                        startActivity(outboundIntent);
                        break;
                    case "Subject2":
                        Intent outboundIntent2 = new Intent(NotePublish.this, Subject2.class);
                        startActivity(outboundIntent2);
                        break;
                    case "Subject3":
                        Intent outboundIntent3 = new Intent(NotePublish.this, Subject3.class);
                        startActivity(outboundIntent3);
                        break;
                    case "Subject4":
                        Intent outboundIntent4 = new Intent(NotePublish.this, Subject4.class);
                        startActivity(outboundIntent4);
                        break;
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