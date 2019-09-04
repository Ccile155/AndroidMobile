package com.example.myfirstapp;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Act3 extends AppCompatActivity {

    private ConstraintLayout mylayout;
    private Act3 myactivity;
    private ImageButton home;
    private ImageButton middle;
    private ImageButton end;
    private int left = 1;
    private int top = 1;
    private int bottom = 1;
    private int right = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_3);

        this.mylayout = findViewById(R.id.layout3);
        mylayout.setBackgroundResource(R.drawable.plage);

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

        ImageView image = new ImageView(this);
        ViewGroup.LayoutParams params = new ActionBar.LayoutParams(150,150);
        image.setLayoutParams(params);

        //ViewGroup.MarginLayoutParams param = (ViewGroup.MarginLayoutParams)image.getLayoutParams();
        //param.setMargins(left, top, right, bottom);
        //image.setLayoutParams(param);

        image.setBackgroundResource(R.drawable.web_hi_res_512);
        image.setCropToPadding(true);

        mylayout.addView(image);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder monPopup = new AlertDialog.Builder(myactivity);
                monPopup.setTitle("Andros");
                monPopup.setMessage("Le meilleur du fruit !");
                //monPopup.setPositiveButtonIcon(R.drawable.ic_sentiment_very_satisfied_black_24dp, n
                monPopup.setPositiveButton("oui", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        Toast.makeText(Act3.this, "ok", Toast.LENGTH_SHORT).show();
                    }
                });

                monPopup.setNegativeButton("non", new  DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        Toast.makeText(Act3.this, "tant pis", Toast.LENGTH_SHORT).show();
                    }

                });
                monPopup.show();
            }
    });

        this.myactivity=this;

        //ViewGroup.LayoutParams params = new ActionBar.LayoutParams(150, 70);
        //text1.setLayoutParams(params);
        //mylayout.addView(text1);
    }
}
