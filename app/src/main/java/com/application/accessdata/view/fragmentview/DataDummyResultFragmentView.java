package com.application.accessdata.view.fragmentview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.application.accessdata.R;
import com.application.accessdata.view.baseview.BaseView;

/**
 * Created by CuongNV on 2/24/2017.
 */

public class DataDummyResultFragmentView implements BaseView {
    private View mRootView;
    public TextView mTvReceiver;

    public DataDummyResultFragmentView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.fragment_data_dummy_result, container, false);
        mTvReceiver = (TextView) mRootView.findViewById(R.id.tv_receiver);
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
