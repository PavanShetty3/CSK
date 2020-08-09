package com.example.csk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();;
        videoHolder=(VideoView) findViewById(R.id.spl);
        Uri video= Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.spl);
        videoHolder.setVideoURI(video);
        videoHolder.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(isFinishing())
                    return;
                startActivity(new Intent(MainActivity.this,FirstPage.class));
                finish();
            }
        });
        videoHolder.start();

    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        try {
            videoHolder.stopPlayback();
        }catch (Exception ex){}
        jump();
        return true;
        }
        private void jump(){
        if(isFinishing())
            return;
        startActivity(new Intent(this,FirstPage.class));
        finish();
    }
}
