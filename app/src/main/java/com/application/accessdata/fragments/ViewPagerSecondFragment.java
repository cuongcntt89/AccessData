package com.application.accessdata.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.accessdata.R;

public class ViewPagerSecondFragment extends Fragment {
    public static final String NAME_PAGE = "SECOND PAGE";

    public ViewPagerSecondFragment() {
        // TODO
    }

    public static ViewPagerSecondFragment newInstance() {
        ViewPagerSecondFragment fragment = new ViewPagerSecondFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager_second, container, false);
        Log.e("ViewPagerSecond => ", "Loaded");
        return view;
    }

}