package com.example.suchi.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button play,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer m = MediaPlayer.create(getApplicationContext(), R.raw.song);

        play = (Button) findViewById(R.id.button);
        stop = (Button) findViewById(R.id.button2);
        Button pause =(Button) findViewById(R.id.button3);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    m.start();
                }
                catch (IllegalStateException a)
                {

                }
                catch (IllegalArgumentException q)
                {

                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.stop();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.pause();
            }
        });
    }

}
