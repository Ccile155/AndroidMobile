package com.example.myfirstapp;

import android.app.NotificationManager;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class myFirebaseMessagingService extends FirebaseMessagingService {

    private static final String CANAL = "MonCanal";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage){
        super.onMessageReceived(remoteMessage);

        String myMessage = remoteMessage.getNotification().getBody();

        Log.d("Welcome", myMessage);

        //affichage
        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(this, CANAL);
        notifBuilder.setContentTitle("Hey!")
                    .setContentText(myMessage)
                    .setSmallIcon(R.drawable.ic_sentiment_very_satisfied_black_24dp)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, notifBuilder.build());

    }
}
