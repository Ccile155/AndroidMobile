package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LegoActivity extends AppCompatActivity {

    private ImageButton previous;
    private ImageButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_layout);

        this.previous = findViewById(R.id.previous);
        previous.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent otherActivity = new Intent(getApplicationContext(), Act3.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }
}
