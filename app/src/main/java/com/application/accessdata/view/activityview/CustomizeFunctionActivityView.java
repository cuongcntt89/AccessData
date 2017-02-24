package com.application.accessdata.view.activityview;

import android.content.Context;
import android.net.rtp.RtpStream;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.application.accessdata.R;
import com.application.accessdata.entity.BuilderPatternDataTest;
import com.application.accessdata.view.baseview.BaseView;

/**
 * Created by CuongNV on 2/24/2017.
 */

public class CustomizeFunctionActivityView implements BaseView {
    private View mRootView;
    public RelativeLayout mViewContainer;

    public CustomizeFunctionActivityView(Context context, ViewGroup viewGroup) {
        mRootView = LayoutInflater.from(context).inflate(R.layout.activity_customize_function, viewGroup);
        mViewContainer = (RelativeLayout) mRootView.findViewById(R.id.container);

        BuilderPatternDataTest builderPatternDataTest = new BuilderPatternDataTest.Builder()
                .setTitle("CuongNV")
                .setNumber(101)
                .build();

//        Log.e("DATA_RESULT => ", "1");
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public Bundle getViewState() {
        return null;
    }
}
