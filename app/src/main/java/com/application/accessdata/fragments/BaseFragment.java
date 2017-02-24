package com.application.accessdata.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by CuongNV on 2/23/2017.
 */

public abstract class BaseFragment extends Fragment {
    protected AbstractFragmentCallback mCallback;
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        mContext = context;
        super.onAttach(context);
        try {
            mCallback = (AbstractFragmentCallback) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement " + AbstractFragmentCallback.class.getCanonicalName());
        }
    }

    public void replaceFragment(Class<? extends Fragment> claz, Fragment parentFragment, int Id, boolean addToBackStack,
                                Bundle args) {
        mCallback.replaceFragment(claz, parentFragment, Id, addToBackStack, args);
    }

    public interface AbstractFragmentCallback {
        public void replaceFragment(Class<? extends Fragment> claz, Fragment parentFragment, int Id, boolean addToBackStack, Bundle args);
        public int getRootId();
    }
}