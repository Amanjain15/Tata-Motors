package com.executives.motors.report_dsm.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 12/4/17.
 */

public class ViewPagerAdapter1 extends FragmentStatePagerAdapter {

//    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> tabTitle=new ArrayList<>();
    private static int a,b;

    public void setTabData(int dealer_id,int c){
        this.a=dealer_id;
        this.b=c;
        tabTitle.add("Daily");
        tabTitle.add("Monthly");
    }

    public ViewPagerAdapter1(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        Log.d("VIEW","dealer"+a+"type"+b+"pos"+position);
        return new Report_dsmFragment().newInstance(a,b,position);//a =user_id, b=user_see_type,pos=daily/monthly
    }


    @Override
    public int getCount() {
        return tabTitle.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle.get(position);
    }


    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view=(View) object;
        container.removeView(view);

    }

}
