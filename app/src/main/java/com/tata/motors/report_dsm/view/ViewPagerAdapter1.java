package com.tata.motors.report_dsm.view;

import android.content.Context;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tata.motors.R;
import com.tata.motors.report_dsm.model.data.ReportDaily;
import com.tata.motors.report_dsm.model.data.ReportMonthly;
import com.tata.motors.report_tsm.view.ReportTsmAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.tata.motors.R.layout.report;

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
