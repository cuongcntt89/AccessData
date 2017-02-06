package com.application.accessdata.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.accessdata.R;

public class FirstLoadFragment extends Fragment {

    public FirstLoadFragment() {
        // TODO
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first_load, container, false);
    }

}