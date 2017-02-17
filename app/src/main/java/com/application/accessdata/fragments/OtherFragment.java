package com.application.accessdata.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.application.accessdata.DataActivity;
import com.application.accessdata.R;

public class OtherFragment extends Fragment {
    private TextView mTvInfo;

    private String result;

    private DataActivity dataActivity;

    public OtherFragment() {
        // TODO
    }

    public static OtherFragment newInstance() {
        OtherFragment fragment = new OtherFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        result = dataActivity.getData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_other, container, false);
        initView(view);
        initEvent();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.dataActivity = (DataActivity) context;
    }

    private void initView(View v) {
        mTvInfo = (TextView) v.findViewById(R.id.tv_info);
        mTvInfo.setText(result);
        dataActivity.tv_showAllway.setText(result);
    }

    private void initEvent() {
        // TODO
    }

}