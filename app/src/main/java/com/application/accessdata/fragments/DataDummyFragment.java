package com.application.accessdata.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.accessdata.R;
import com.application.accessdata.entity.DataDummy;
import com.application.accessdata.utils.Constants;
import com.application.accessdata.view.view.fragmentview.DataDummyFragmentView;

import java.util.ArrayList;
import java.util.List;

public class DataDummyFragment extends BaseFragment {
    private DataDummyFragmentView dataDummyFragmentView;
    private List<DataDummy> dataDummies = new ArrayList<>();

    public DataDummyFragment() {
        // TODO
    }

    public static DataDummyFragment newInstance() {
        DataDummyFragment fragment = new DataDummyFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataDummyFragmentView = new DataDummyFragmentView(inflater, container);

        dataDummies.add(new DataDummy(0, "NguyenDev89", "GVN Company"));
        dataDummies.add(new DataDummy(1, "DevTest", "GVN Company"));

        dataDummyFragmentView.mButtonSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundleData = new Bundle();
                bundleData.putParcelable(Constants.KEY_SEND_DATA, dataDummies.get(0));
                replaceFragment(DataDummyResultFragment.class, getParentFragment(), R.id.view_container, true, bundleData);
            }
        });

        return dataDummyFragmentView.getRootView();
    }

}