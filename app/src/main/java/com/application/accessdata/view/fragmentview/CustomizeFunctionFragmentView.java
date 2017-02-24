package com.application.accessdata.view.fragmentview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.application.accessdata.R;
import com.application.accessdata.view.baseview.BaseView;

/**
 * Created by CuongNV on 2/24/2017.
 */

public class CustomizeFunctionFragmentView implements BaseView{
    private View mRootView;
    public Button mButtonShowDialog;

    public CustomizeFunctionFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        mRootView = layoutInflater.inflate(R.layout.fragment_customize_function, viewGroup, false);
        mButtonShowDialog = (Button) mRootView.findViewById(R.id.bt_show_dialog);
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
