package com.application.accessdata.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.application.accessdata.R;

public class DFragment extends Fragment implements View.OnClickListener {
    private Button bt_gotoPage;
    public static final String TAG = "SCREEN_D";

    public static DFragment newInstance() {
        DFragment fragment = new DFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d, container, false);
        initView(view);
        initEvent();
        return view;
    }

    private void initView(View v) {
        bt_gotoPage = (Button) v.findViewById(R.id.bt_gotoPage);
    }

    private void initEvent() {
        bt_gotoPage.setOnClickListener(this);
    }

    private void backPage() {
        // TODO
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_gotoPage :
                backPage();
                break;
            default:
                break;
        }
    }

}