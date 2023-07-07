package com.example.saveandplaynotification;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;



public class RingtonePlayer {
    public static void play(Context context, Uri soundUri,int duration){
        try{
            MediaPlayer mediaPlayer= new MediaPlayer();
            mediaPlayer.setDataSource(context,soundUri);
            mediaPlayer.prepare();
            mediaPlayer.start();

            //stop playback after the duratiion
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.release();
                }
            });

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
