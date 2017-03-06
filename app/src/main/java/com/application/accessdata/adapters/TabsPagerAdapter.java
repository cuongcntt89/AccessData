package com.application.accessdata.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.application.accessdata.fragments.AnnotationsFragment;
import com.application.accessdata.fragments.ViewPagerFirstFragment;
import com.application.accessdata.fragments.ViewPagerSecondFragment;
import com.application.accessdata.fragments.ViewPagerThirdFragment;

import java.util.List;

/**
 * Created by CuongNV on 3/6/2017.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public TabsPagerAdapter(FragmentManager fm,  List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        Fragment fragment = fragments.get(position);
        if (fragment instanceof ViewPagerFirstFragment) {
            title = ViewPagerFirstFragment.NAME_PAGE;
        }else if (fragment instanceof ViewPagerSecondFragment) {
            title = ViewPagerSecondFragment.NAME_PAGE;
        }else if (fragment instanceof AnnotationsFragment) {
            title = AnnotationsFragment.NAME_PAGE;
        }else {
            title = ViewPagerThirdFragment.NAME_PAGE;
        }

        return title;
    }

}