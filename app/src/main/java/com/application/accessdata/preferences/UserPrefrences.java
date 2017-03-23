package com.application.accessdata.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by CuongNV on 3/22/2017.
 */

public class UserPrefrences {
    public static final String TAG = "UserPrefrences";
    public static final String KEY_TOKEN = "user.prefrence.token";
    private final SharedPreferences mPreferences;
    private static UserPrefrences instance;

    private UserPrefrences(Context context) {
        mPreferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
    }

    public static UserPrefrences getInstance(Context context) {
        if (instance == null) {
            instance = new UserPrefrences(context.getApplicationContext());
        }
        return instance;
    }

    public String getToken() {
        return mPreferences.getString(KEY_TOKEN, "");
    }

    public void setToken(String token) {
        mPreferences.edit().putString(KEY_TOKEN, token).apply();
    }

}