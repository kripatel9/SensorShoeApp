package com.roboraiders.shoeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private SeekBar transparency;
    private Button toSessionMgr;
    private ImageView pain1s, pain2s, pain3s, pain1b, pain2b, pain3b;
    private int transparencyNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        transparency = findViewById(R.id.transparencyBar);
        pain1s = findViewById(R.id.sidePain1);
        pain2s = findViewById(R.id.sidePain2);
        pain3s = findViewById(R.id.sidePain3);
        pain1b = findViewById(R.id.bottomPain1);
        pain2b = findViewById(R.id.bottomPain2);
        pain3b = findViewById(R.id.bottomPain3);
        toSessionMgr = findViewById(R.id.toSessionActivityBtn);
        transparency.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                transparencyNum = progress;
                pain1s.setAlpha(transparencyNum);
                pain2s.setAlpha(transparencyNum);
                pain3s.setAlpha(transparencyNum);
                pain1b.setAlpha(transparencyNum);
                pain2b.setAlpha(transparencyNum);
                pain3b.setAlpha(transparencyNum);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        toSessionMgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceedSessionActivity();
            }
        });
    }
    private void proceedSessionActivity() {
        Intent intent = new Intent(MainActivity.this, SessionActivity.class);
        startActivity(intent);
    }
}
