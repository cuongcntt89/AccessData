package com.application.accessdata.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.application.accessdata.DataActivity;
import com.application.accessdata.R;

public class ReceiveFragment extends Fragment implements View.OnClickListener {
    public static final String KEY_DATA = "key.data";
    private String result = "";

    private TextView mTvResult;
    private Button mBtGotoScreenOther;

    private DataActivity dataActivity;

    public ReceiveFragment() {
        // TODO
    }

    public static ReceiveFragment newInstance() {
        ReceiveFragment receiveFragment = new ReceiveFragment();
        return receiveFragment;
    }

    public static ReceiveFragment newInstance(String input) {
        ReceiveFragment fragment = new ReceiveFragment();
        Bundle args = new Bundle();
        args.putString(KEY_DATA, input);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        result = dataActivity.getData();
        if (getArguments() != null) {
//            this.result = getArguments().getString(KEY_DATA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receive, container, false);
        initView(view);
        initEvent();
        return view;
    }

    private void initView(View v) {
        mTvResult = (TextView) v.findViewById(R.id.tv_result);
        mBtGotoScreenOther = (Button) v.findViewById(R.id.bt_gotoScreenOther);
        dataActivity.tv_showAllway.setText(result);
        mTvResult.setText(this.result);
    }

    private void initEvent() {
        mBtGotoScreenOther.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.dataActivity = (DataActivity) context;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_gotoScreenOther :
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.anim_slide_in_left, R.anim.anim_slide_in_right,
                        R.anim.anim_slide_out_left, R.anim.anim_slide_out_right);
                transaction.replace(R.id.block_content, OtherFragment.newInstance());
                transaction.addToBackStack(null);
                transaction.commit();

                break;
            default:
                break;
        }
    }
}