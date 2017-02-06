package com.application.accessdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.application.accessdata.fragments.SecondLoadFragment;

public class SecondLoadActivity extends AppCompatActivity {

    private FrameLayout mSecondLoadContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_load);

        initView();

        if (mSecondLoadContentView != null) {
            if (savedInstanceState != null) {
                return;
            }

            SecondLoadFragment secondLoadFragment = new SecondLoadFragment();
            secondLoadFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.second_load_content_view, secondLoadFragment).commit();
        }

        initEvent();
    }

    private void initView() {
        mSecondLoadContentView = (FrameLayout) findViewById(R.id.second_load_content_view);
    }

    private void initEvent() {
        // TODO
    }
}
