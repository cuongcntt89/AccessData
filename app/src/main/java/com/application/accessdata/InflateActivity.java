package com.application.accessdata;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.application.accessdata.fragments.BaseFragment;
import com.application.accessdata.fragments.DataDummyFragment;
import com.application.accessdata.view.activityview.InflateActivityView;

public class InflateActivity extends AppCompatActivity implements BaseFragment.AbstractFragmentCallback {
    private InflateActivityView inflateActivityView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflateActivityView = new InflateActivityView(this, null);
        setContentView(inflateActivityView.getRootView());

        if (inflateActivityView.mViewContainer != null) {
            if (savedInstanceState != null) {
                return;
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.view_container, DataDummyFragment.newInstance());
            transaction.commit();
        }
    }

    private boolean isFragmentShown(Class<? extends Fragment> claz, int Id) {
        Fragment currFragment = getSupportFragmentManager().findFragmentById(Id);
        return (currFragment == null && claz == null) || (currFragment != null && claz.isInstance(currFragment));
    }

    @Override
    public void replaceFragment(Class<? extends Fragment> claz, Fragment parentFragment, int Id, boolean addToBackStack, Bundle args) {
        if (isFragmentShown(claz, Id)) {
            return;
        }
        FragmentTransaction ft;
        if (parentFragment != null) {
            ft = parentFragment.getChildFragmentManager().beginTransaction();
        } else {
            ft = getSupportFragmentManager().beginTransaction();
        }

        Fragment newFragment;
        try {
            newFragment = claz.newInstance();

            if (args != null) newFragment.setArguments(args);
        } catch (InstantiationException e) {
            e.printStackTrace();
            return;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return;
        }

        if (addToBackStack) {
            ft.addToBackStack(null);
        }
        ft.replace(Id, newFragment, claz.getClass().getSimpleName());
        ft.commitAllowingStateLoss();
    }

    @Override
    public int getRootId() {
        return 0;
    }
}