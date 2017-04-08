package com.tata.motors.welcome_screen.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tata.motors.R;

import com.tata.motors.helper.image_loader.GlideImageLoader;
import com.tata.motors.helper.image_loader.ImageLoader;
import com.tata.motors.login.view.LoginScreenActivity;
import com.tata.motors.welcome_screen.model.data.WelcomeImageDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 30/12/16.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<WelcomeImageDetails> welcomeImageDetailsList= new ArrayList<>();
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;

    public ViewPagerAdapter(Context context) {

        imageLoader = new GlideImageLoader(context);
        this.context = context;
    }


    public void setImageList(List<WelcomeImageDetails> welcomeImageDetailsList) {
        this.welcomeImageDetailsList = welcomeImageDetailsList;
    }

    @Override
    public Object instantiateItem(ViewGroup container,int position){

        layoutInflater =LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.welcome_view_pager_item, container, false);
        container.addView(view);
        WelcomeImageDetails welcomeImageDetails = welcomeImageDetailsList.get(position);
        TextView textView=(TextView) view.findViewById(R.id.textView1);
        ImageView imageView=(ImageView) view.findViewById(R.id.img);
        ProgressBar progressBar =(ProgressBar) view.findViewById(R.id.imgProgressBar);
//        Button button = (Button)view.findViewById(R.id.button_next);

        textView.setText(welcomeImageDetails.getMessage());
        imageLoader.loadImage(welcomeImageDetails.getImage_url(),imageView,progressBar);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void  onClick(View v)
//            {
//
//            }
//        });

    return view;

    }



    @Override
    public int getCount() {
        return welcomeImageDetailsList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view=(View) object;
        container.removeView(view);

    }
}
