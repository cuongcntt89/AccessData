package com.application.accessdata.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.accessdata.R;

public class ViewPagerFirstFragment extends Fragment {
    public static final String NAME_PAGE = "FIRST PAGE";

    public ViewPagerFirstFragment() {
        // TODO
    }


    public static ViewPagerFirstFragment newInstance() {
        ViewPagerFirstFragment fragment = new ViewPagerFirstFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_pager_first, container, false);
    }

}