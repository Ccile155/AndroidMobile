package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LegoActivity extends AppCompatActivity {

    private ImageButton home;
    private ImageButton middle;
    private ImageButton end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_layout);

        this.home = findViewById(R.id.home_button);
        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.middle = findViewById(R.id.middle);
        middle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent otherActivity = new Intent(getApplicationContext(), LegoActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.end = findViewById(R.id.end);
        end.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent otherActivity = new Intent(getApplicationContext(), Act3.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }
}
