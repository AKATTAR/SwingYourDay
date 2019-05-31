package com.example.swingyourday;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {
    SoundPool sp;
    MediaPlayer mm,mm1;
    int explosion = 0;
    Random crazy = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//implement the xml files or display the xml file with the help of set contain view
        View v = new View(this);
        v.setOnClickListener(this);
        v.setOnLongClickListener(this);
        v.setOnTouchListener(this);
        setContentView(v);
        mm = MediaPlayer.create(this, R.raw.backgroundmusic);
        mm1 = MediaPlayer.create(this, R.raw.soundtrack);
        sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        explosion = sp.load(this, R.raw.explosion, 1);
        v.setBackgroundColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265), crazy.nextInt(265)));
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        Toast.makeText(this, "this is pointer", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "this on click listener", Toast.LENGTH_SHORT).show();
        if (explosion != 0)
            sp.play(explosion, 1, 1, 0, 0, 1);
        v.setBackgroundColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265), crazy.nextInt(265)));
    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(this, "OnLong click", Toast.LENGTH_SHORT).show();
        mm.start();
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Toast.makeText(this, "on touch", Toast.LENGTH_SHORT).show();
        mm1.start();
        return false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mm.release();
    }
}