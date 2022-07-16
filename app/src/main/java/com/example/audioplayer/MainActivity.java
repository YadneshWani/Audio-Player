package com.example.audioplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    Button start, pause, stop;
    MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.button1);
        pause = (Button) findViewById(R.id.button2);
        stop = (Button) findViewById(R.id.button3);
        //creating media player

        //you can change the path, here path is external directory(e.g. sdcard) /Music/maine.mp3

        start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player==null)
                {
                    player=MediaPlayer.create(MainActivity.this,R.raw.song);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            player.stop();
                        }
                    });
                }
                player.start();

            }
        });

        stop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(player !=null)
                {
                    player.stop();
                }

            }
        });


        pause.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player !=null)
                {
                    player.pause();
                }

            }
        });

    }

}
