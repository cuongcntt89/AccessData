package com.application;

import android.app.Application;

import com.application.accessdata.utils.Constants;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

/**
 * Created by CuongNV on 2/6/2017.
 */

public class MyApplication extends Application {
    public static final String TAG = MyApplication.class.getSimpleName();
    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        // MultiDex.install(this);
        mInstance = this;
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }
}