package com.application.accessdata.utils;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by CuongNV on 3/9/2017.
 */

public class BaseSingleton {
    private String mString;

    private static BaseSingleton mInstance = null;

    private BaseSingleton() {
        this.mString = "Hello";
    }

    public static BaseSingleton getInstance() {
        if (mInstance == null) {
            mInstance = new BaseSingleton();
        }
        return mInstance;
    }

    public String getmString() {
        return this.mString;
    }

    public void setmString(String mString) {
        this.mString = mString;
    }

    private class ConnectAsync extends AsyncTask<String, Void, InputStream> {
        private InputStream inputStream;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected InputStream doInBackground(String... params) {
            URL url;
            HttpURLConnection urlConnection = null;
            InputStream in = null;
            try {
                url = new URL("http://10.64.1.114/");
                urlConnection = (HttpURLConnection) url.openConnection();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                in = new BufferedInputStream(urlConnection.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }

            return in;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            super.onPostExecute(inputStream);

        }
    }

}