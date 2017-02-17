package com.application.accessdata;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.application.accessdata.fragments.ReceiveFragment;
import com.application.accessdata.fragments.SendDataFragment;

public class DataActivity extends AppCompatActivity implements SendDataFragment.OnSendDataListener {
    public TextView tv_showAllway;
    private String dataSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        tv_showAllway = (TextView) findViewById(R.id.tv_showAllway);

        int displayMode = getResources().getConfiguration().orientation;
        if (displayMode == Configuration.ORIENTATION_PORTRAIT) {
            if (findViewById(R.id.block_content) != null) {
                if (savedInstanceState != null) {
                    return;
                }
                SendDataFragment sendDataFragment = new SendDataFragment();
                sendDataFragment.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.block_content, sendDataFragment).commit();
            }
        }else {
            if (findViewById(R.id.block_send) != null) {
                SendDataFragment sendDataFragment = new SendDataFragment();
                sendDataFragment.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.block_send, sendDataFragment).commit();
            }

            if (findViewById(R.id.block_receiver) != null) {
                ReceiveFragment receiveFragment = new ReceiveFragment();
                receiveFragment.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.block_receiver, receiveFragment).commit();
            }
        }
    }

    @Override
    public void onSendData(String s) {
        this.dataSend = s;
    }

    public String getData() {
        return this.dataSend;
    }

}