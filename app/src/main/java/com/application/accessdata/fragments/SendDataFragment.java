package com.application.accessdata.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.application.accessdata.R;

public class SendDataFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private Button mBtSendData;

    private OnSendDataListener mListener;

    public SendDataFragment() {
        // TODO
    }

    public static SendDataFragment newInstance() {
        SendDataFragment sendDataFragment = new SendDataFragment();
        return sendDataFragment;
    }

    public static SendDataFragment newInstance(String param1, String param2) {
        SendDataFragment fragment = new SendDataFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send_data, container, false);
        initView(view); // init view
        initEvent();    // init event
        return view;
    }

    private void initView (View v) {
        mBtSendData = (Button) v.findViewById(R.id.bt_senđData);
    }

    private void initEvent() {
        mBtSendData.setOnClickListener(this);
    }

    public void onButtonPressed(String s) {
        if (mListener != null) {
            mListener.onSendData(s);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnSendDataListener) activity;
        }catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_senđData:
                onButtonPressed("Hi. I am gosu.");  // Tranfer data using interface
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.anim_slide_in_left, R.anim.anim_slide_in_right,
                        R.anim.anim_slide_out_left, R.anim.anim_slide_out_right);
                transaction.replace(R.id.block_content, ReceiveFragment.newInstance());
                transaction.addToBackStack(null);
                transaction.commit();

//                replacePage("Hi. I am gosu."); // Tranfer data using set variable send data
                break;

            default:
                break;
        }
    }

    private void replacePage(Object o) {
        if (o instanceof String) {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.anim_slide_in_left, R.anim.anim_slide_in_right,
                    R.anim.anim_slide_out_left, R.anim.anim_slide_out_right);
            transaction.replace(R.id.block_content, ReceiveFragment.newInstance(o.toString()));
            transaction.addToBackStack(null);
            transaction.commit();
            return;
        }
        return;
    }

    public interface OnSendDataListener {
        void onSendData(String s);
    }

}