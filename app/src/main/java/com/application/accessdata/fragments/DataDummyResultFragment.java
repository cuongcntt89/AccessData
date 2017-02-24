package com.application.accessdata.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.application.accessdata.R;
import com.application.accessdata.entity.DataDummy;
import com.application.accessdata.utils.Constants;

public class DataDummyResultFragment extends Fragment {
    private DataDummy dataDummy;
    private String result;

    private TextView mTvReceiver;

    public DataDummyResultFragment() {
        // TODO
    }

    public static DataDummyResultFragment newInstance() {
        DataDummyResultFragment fragment = new DataDummyResultFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dataDummy = getArguments().getParcelable(Constants.KEY_SEND_DATA);
            this.result = dataDummy.mTitle + " ----- " + dataDummy.mDescription;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data_dummy_result, container, false);
        mTvReceiver = (TextView) view.findViewById(R.id.tv_receiver);
        mTvReceiver.setText(this.result);

        return view;
    }

}