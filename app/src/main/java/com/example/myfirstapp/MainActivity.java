package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView dandelion;
    private Button getstart;
    private TextView count;
    static Integer cpt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dandelion = findViewById(R.id.dandelion);
        this.count = (TextView) findViewById(R.id.count);


        dandelion.setOnClickListener(new View.OnClickListener(){
            @Override
           public void onClick(View view){
                ++ cpt;
                count.setText("Vous avez cliqué "+cpt+" fois!");
                Matrix matrix = new Matrix();
                dandelion.setScaleType(ImageView.ScaleType.MATRIX);   //required
                matrix.postRotate( 45, dandelion.getDrawable().getBounds().width()/2, dandelion.getDrawable().getBounds().height()/2);
                dandelion.setImageMatrix(matrix);
            }
       });

        this.getstart = findViewById(R.id.getstart);
        getstart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent otherActivity = new Intent(getApplicationContext(), LegoActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

    }
}
