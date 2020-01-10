package com.hzskfzx.demo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;
public class SecondActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer=new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button=findViewById(R.id.btnSpeak);

        try {
            Log.d("Tag","init");
            mediaPlayer.setDataSource("http://192.168.0.2:7003/upload/1.mp3");
            mediaPlayer.prepare();
        } catch (IOException e) {
            Log.d("Tag",e.toString());
            Toast.makeText(SecondActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
            button.setClickable(false);
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()==false) {
                    mediaPlayer.start();
                    mediaPlayer.setVolume(1f,1f);
                    Log.d("Tag","Start");
                }
                else{
                    Log.d("Tag","Playing");
                }
            }
        });
    }
}
