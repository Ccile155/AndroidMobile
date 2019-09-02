package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;

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
                count.setText(cpt);
                Matrix matrix = new Matrix();
                dandelion.setScaleType(ImageView.ScaleType.MATRIX);   //required
                matrix.postRotate( 180f, dandelion.getDrawable().getBounds().width()/2, dandelion.getDrawable().getBounds().height()/2);
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
