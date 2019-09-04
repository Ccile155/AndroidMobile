package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity{

    private MediaPlayer mp;
    private ImageView dandelion;
    private ImageButton getstart;
    private TextView count;
    static Integer cpt = 0;

    public void sound(View view){
        if(mp != null && mp.isPlaying()) {
            mp.pause();
        } else mp.start();
    }

    public void gray(int i){
        ColorMatrix matrix = new ColorMatrix();
        if(i % 2 == 0) {
            matrix.setSaturation(0);
            dandelion.setColorFilter(new ColorMatrixColorFilter(matrix));
        } else {
            matrix.setSaturation(1);
            dandelion.setColorFilter(new ColorMatrixColorFilter(matrix));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dandelion = findViewById(R.id.dandelion);
        this.count = findViewById(R.id.count);
        this.getstart = findViewById(R.id.getstart);
        this.mp = MediaPlayer.create(getApplicationContext(), R.raw.mouette);

        dandelion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ++cpt;
                count.setText("Vous avez cliqué " + cpt + " fois!");
                sound(view);
                gray(cpt);
                //Matrix matrix = new Matrix();
                //dandelion.setScaleType(ImageView.ScaleType.MATRIX);   //required
                //matrix.postRotate(45, dandelion.getDrawable().getBounds().width() / 2, dandelion.getDrawable().getBounds().height() / 2);
                //dandelion.setImageMatrix(matrix);
            }
        });

        getstart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), LegoActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }
}
