package com.example.saveandplaynotification;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;


public class RingtonePlayer {
    public static void play(Context context, Uri soundUri,int durationInSeconds){
        try{
            MediaPlayer mediaPlayer= new MediaPlayer();
            mediaPlayer.setDataSource(context,soundUri);
            mediaPlayer.prepare();
            mediaPlayer.start();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mediaPlayer.stop();
                }
            },durationInSeconds);

            //stop playback after the duratiion
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.stop();
                }
            });

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
