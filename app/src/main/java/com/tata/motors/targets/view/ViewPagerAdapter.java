package com.tata.motors.targets.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tata.motors.R;

/**
 * Created by aman on 11/3/17.
 */

public class ViewPagerAdapter extends PagerAdapter {

    final int TAB_COUNT=2;
    private String tabTitles[] = new String[]{"Daily","Monthly"};
    private String targetDaily;
    private String targetMonthly;
    private Context context;


    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    public void setData(String targetDaily,String targetMonthly){
        this.targetDaily=targetDaily;
        this.targetMonthly=targetMonthly;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.target_view_pager_item,container,false);
        container.addView(view);
        TextView textView = (TextView) view.findViewById(R.id.txtTarget);
        if(position==1)
            textView.setText(targetMonthly);
        else
            textView.setText(targetDaily);
        return  view;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitles[position];
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
