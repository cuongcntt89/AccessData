package com.application.accessdata.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.accessdata.R;

public class ViewPagerThirdFragment extends Fragment {
    public static final String NAME_PAGE = "THIRD PAGE";

    public ViewPagerThirdFragment() {
        // TODO
    }

    public static ViewPagerThirdFragment newInstance() {
        ViewPagerThirdFragment fragment = new ViewPagerThirdFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager_third, container, false);
        Log.e("ViewPagerThird => ", "Loaded");
        return view;
    }

}