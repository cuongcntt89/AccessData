package com.application.accessdata.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.application.accessdata.R;

public class BFragment extends Fragment implements View.OnClickListener {
    private Button bt_gotoPage;
    public static final String TAG = "SCREEN_B";
    public static final String STACK = "B_FOR_C";

    public static BFragment newInstance() {
        BFragment fragment = new BFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
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

    private void gotoPage() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.anim_slide_in_left, R.anim.anim_slide_in_right,
                R.anim.anim_slide_out_left, R.anim.anim_slide_out_right);
        transaction.replace(R.id.back_stack_content, CFragment.newInstance(), CFragment.TAG);
        transaction.addToBackStack(STACK );
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_gotoPage :
                gotoPage();
                break;

            default:
                break;
        }
    }

}