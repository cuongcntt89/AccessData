package com.application.accessdata.services;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class DownloadService extends IntentService {

    public static final String URL_PATH = "http://www.objgen.com/json";
    public static final String RESULT_DATA = "result.data";
    public static final String RESULT_STATE = "result.state";

    private int result_state = Activity.RESULT_CANCELED;
    public static final String NOTIFICATION = "com.application.accessdata.services";

    public DownloadService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String urlPath = intent.getStringExtra(URL_PATH);
            InputStream inputStream = null;
            String result_content = "";
            try {
                URL url = new URL(urlPath);
                inputStream = url.openConnection().getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                int next = -1;
                while ((next = inputStreamReader.read()) != -1) {
                    result_content += next;
                }
                result_state = Activity.RESULT_OK;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            publishResults(result_content, result_state);
        }
    }

    private void publishResults(String result_content, int result_state) {
        Intent intent = new Intent(NOTIFICATION);
        intent.putExtra(RESULT_DATA, result_content);
        intent.putExtra(RESULT_STATE, result_state);
        sendBroadcast(intent);
    }

}