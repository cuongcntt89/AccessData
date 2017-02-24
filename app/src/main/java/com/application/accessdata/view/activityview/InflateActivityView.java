package com.application.accessdata.view.activityview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.application.accessdata.R;
import com.application.accessdata.view.baseview.BaseView;

/**
 * Created by CuongNV on 2/23/2017.
 */

public class InflateActivityView implements BaseView {
    private View mRootView;
    public RelativeLayout mViewContainer;

    public InflateActivityView(Context context, ViewGroup viewGroup) {
        mRootView = LayoutInflater.from(context).inflate(R.layout.activity_inflate, viewGroup);
        mViewContainer = (RelativeLayout) mRootView.findViewById(R.id.view_container);
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