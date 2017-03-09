package com.application.accessdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.application.accessdata.utils.BaseSingleton;

public class SingletonActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButtonGotoScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton);

        Toast.makeText(this, BaseSingleton.getInstance().getmString(), Toast.LENGTH_SHORT).show();

        mButtonGotoScreen = (Button) findViewById(R.id.bt_goto_screen);
        mButtonGotoScreen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_goto_screen) {
            BaseSingleton.getInstance().setmString("Singleton created");
            Intent intent = new Intent(SingletonActivity.this, SingletonToActivity.class);
            startActivity(intent);
        }
    }
}
