package com.executives.motors.targets.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.executives.motors.R;

/**
 * Created by aman on 11/3/17.
 */

public class ViewPagerAdapter extends PagerAdapter {

    int TAB_COUNT=3;
    private String tabTitles[] = new String[]{"Daily","Monthly","FollowUp"};
    private String targetDaily;
    private String targetMonthly;
    private Context context;
    LayoutInflater layoutInflater;
    String user_type,followUp;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    public void setData(String targetDaily,String targetMonthly,String follow,String user_type){
        this.targetDaily=targetDaily;
        Log.d("viewpager",targetDaily+""+this.targetDaily);
        this.targetMonthly=targetMonthly;
        this.user_type=user_type;
        this.followUp=follow;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.target_view_pager_item,container,false);
        container.addView(view);
        TextView textView = (TextView) view.findViewById(R.id.txtTarget);
        Log.d("viewpager",targetDaily+"");
        textView.setText(targetDaily);
        if(position==0)
            textView.setText(targetDaily);
        else if(position==1)
            textView.setText(targetMonthly);
        else
            textView.setText(followUp);
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

    @Override
    public int getItemPosition(Object object)
    {

        return POSITION_NONE;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view=(View) object;
        container.removeView(view);

    }

}
