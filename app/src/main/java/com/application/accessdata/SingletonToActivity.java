package com.application.accessdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.application.accessdata.utils.BaseSingleton;

public class SingletonToActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton_to);

        Toast.makeText(getApplicationContext(), BaseSingleton.getInstance().getmString(), Toast.LENGTH_SHORT).show();
    }
}