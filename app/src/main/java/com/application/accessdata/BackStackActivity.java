package com.application.accessdata;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.application.accessdata.fragments.AFragment;
import com.application.accessdata.fragments.BFragment;
import com.application.accessdata.fragments.CFragment;
import com.application.accessdata.fragments.DFragment;

public class BackStackActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout blockContent;
    private Button mBtBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_stack);

        // init view
        mBtBack = (Button) findViewById(R.id.bt_back);
        blockContent = (RelativeLayout) findViewById(R.id.back_stack_content);
        // init event
        mBtBack.setOnClickListener(this);

        if (blockContent != null) {
            if (savedInstanceState != null) {
                return;
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.back_stack_content, AFragment.newInstance());
            transaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().findFragmentByTag(DFragment.TAG) != null) {
            // getSupportFragmentManager().popBackStack(BFragment.STACK, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_back:
                super.onBackPressed();
                break;
        }
    }

}