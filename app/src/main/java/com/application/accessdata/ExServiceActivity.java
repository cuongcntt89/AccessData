package com.application.accessdata;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.application.accessdata.R;
import com.application.accessdata.services.DownloadService;

public class ExServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnGetData;
    private TextView mTvResultData;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String result = bundle.getString(DownloadService.RESULT_DATA);
                int state = bundle.getInt(DownloadService.RESULT_STATE);
                if (state == RESULT_OK) {
                    Toast.makeText(ExServiceActivity.this, "Download completed.", Toast.LENGTH_LONG)
                            .show();
                    mTvResultData.setText(result);
                } else {
                    Toast.makeText(ExServiceActivity.this, "Download failed", Toast.LENGTH_LONG)
                            .show();
                    mTvResultData.setText("Download failed");
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_service);
        mBtnGetData = (Button) findViewById(R.id.btn_getData);
        mTvResultData = (TextView) findViewById(R.id.tv_resultData);
        mBtnGetData.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_getData:
                Intent intent = new Intent(this, DownloadService.class);
                intent.putExtra(DownloadService.FILENAME, "index.html");
                intent.putExtra(DownloadService.URL,
                        "http://www.vogella.com/index.html");
                startService(intent);
                mTvResultData.setText("Service started");

                break;
            default:
                break;
        }
    }
}
