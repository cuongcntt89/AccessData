package com.application.accessdata;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.widget.Toast;

import com.application.accessdata.adapters.TabsPagerAdapter;
import com.application.accessdata.fragments.ViewPagerFirstFragment;
import com.application.accessdata.fragments.ViewPagerSecondFragment;
import com.application.accessdata.fragments.ViewPagerThirdFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends FragmentActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private TabsPagerAdapter tabsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        List<Fragment> fragments = getFragments();
        FragmentManager fragmentManager = getSupportFragmentManager();
        tabsPagerAdapter = new TabsPagerAdapter(fragmentManager, fragments);
        viewPager.setAdapter(tabsPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(ViewPagerFirstFragment.newInstance());
        fragmentList.add(ViewPagerSecondFragment.newInstance());
        fragmentList.add(ViewPagerThirdFragment.newInstance());
        return fragmentList;
    }

}