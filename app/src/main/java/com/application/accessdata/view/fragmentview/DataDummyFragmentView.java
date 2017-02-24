package com.application.accessdata.view.fragmentview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.application.accessdata.R;
import com.application.accessdata.view.baseview.BaseView;

/**
 * Created by CuongNV on 2/23/2017.
 */

public class DataDummyFragmentView implements BaseView {
    private View mRootView;
    public Button mButtonSendData;

    public DataDummyFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        mRootView = layoutInflater.inflate(R.layout.fragment_data_dummy, viewGroup, false);
        mButtonSendData = (Button) mRootView.findViewById(R.id.bt_sendDataDummy);
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