package com.tata.motors.report.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class ViewPagerAdapter extends FragmentPagerAdapter {

    final int TAB_COUNT = 2;
    private String tabTitles[] = new String[]{"Daily","Monthly"};

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return ReportFragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
   }
