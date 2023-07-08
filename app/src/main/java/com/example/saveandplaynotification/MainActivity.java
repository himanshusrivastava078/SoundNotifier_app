package com.example.saveandplaynotification;

import androidx.annotation.Nullable;


import android.app.Activity;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

   private Button btnSelectSound;
   private Button btnPlayNotification;
   private  EditText etDuration;
   private Uri selectedSoundUri;
   private int durationInSeconds;
   private int duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelectSound= findViewById(R.id.btnSelectSound);
        btnPlayNotification=findViewById(R.id.btnPlayNotification);
        etDuration = findViewById(R.id.etDuration);

        btnSelectSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setType("audio/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,1);

            }
        });

        btnPlayNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String durationText= etDuration.getText().toString();
                if(!durationText.isEmpty()){
                    durationInSeconds = Integer.parseInt(durationText);
                    duration = durationInSeconds*1000;

                    //play the selected notification sound for the specified duration
                    if(selectedSoundUri!=null){
                        // Add your code to play the  notication sound here
                        Toast.makeText(MainActivity.this, "Playing notification for "+ durationInSeconds + " seconds.", Toast.LENGTH_SHORT).show();

                        RingtonePlayer.play(MainActivity.this,selectedSoundUri,duration);

                    }else{
                        Toast.makeText( MainActivity.this, "Please Select a notication Sound.", Toast.LENGTH_SHORT).show();
                    }
                }else{

                    Toast.makeText(MainActivity.this, "Please Enter the Duration", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== 1 && resultCode==RESULT_OK){
            selectedSoundUri= data.getData();

        }
    }
}