package com.application.accessdata.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ExService extends Service {
    public ExService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }
}
