package com.application.accessdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.application.accessdata.services.PlaySongService;

public class ExServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnStart, mBtnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_service);

        mBtnStart = (Button) findViewById(R.id.btn_start);
        mBtnStop = (Button) findViewById(R.id.btn_stop);
        mBtnStart.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopSong();
    }

    public void playSong()  {
        Intent myIntent = new Intent(this, PlaySongService.class);
        startService(myIntent);
    }

    public void stopSong()  {
        Intent myIntent = new Intent(this, PlaySongService.class);
        stopService(myIntent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                playSong();
                break;
            case R.id.btn_stop:
                stopSong();
            default:
                break;
        }
    }

}