package com.application.accessdata.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.application.accessdata.R;
import com.application.accessdata.view.customize.dialog.DialogCustomize;
import com.application.accessdata.view.fragmentview.CustomizeFunctionFragmentView;

public class CustomizeFunctionFragment extends Fragment {
    private CustomizeFunctionFragmentView customizeFunctionFragmentView;

    public CustomizeFunctionFragment() {
        // Required empty public constructor
    }

    public static CustomizeFunctionFragment newInstance() {
        CustomizeFunctionFragment fragment = new CustomizeFunctionFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        customizeFunctionFragmentView = new CustomizeFunctionFragmentView(inflater, container);

        customizeFunctionFragmentView.mButtonShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogCustomize dialogCustomize = new DialogCustomize(getActivity(), "Error", "Could not connect to server !", "OK");
                dialogCustomize.setOnOkClickListener(new DialogCustomize.OnOkClickListener() {
                    @Override
                    public void onOkClick() {
                         Toast.makeText(getActivity().getApplicationContext(), "Clicked button OK then dismiss Dialog", Toast.LENGTH_SHORT).show();
                    }
                });
                dialogCustomize.setOnCancelClickListener(new DialogCustomize.OnCancelClickListener() {
                    @Override
                    public void onCancelClick() {
                        Toast.makeText(getActivity().getApplicationContext(), "Clicked button Cancel then dismiss Dialog", Toast.LENGTH_SHORT).show();
                    }
                });
                dialogCustomize.show();
            }
        });

        return customizeFunctionFragmentView.getRootView();
    }

}