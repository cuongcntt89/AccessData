package com.application.accessdata.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.application.accessdata.utils.NetworkUtils;

public class NetworkReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (NetworkUtils.isNetworkAvailable(context)) {
            Toast.makeText(context, "Network is available", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Network is not available", Toast.LENGTH_SHORT).show();
            return;
        }
    }

}