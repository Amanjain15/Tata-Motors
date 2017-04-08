package com.tata.motors.welcome_screen.model;

import android.os.Handler;
import android.util.Log;

import com.tata.motors.welcome_screen.WelcomeScreenCallBack;
import com.tata.motors.welcome_screen.model.data.WelcomeImageDetails;
import com.tata.motors.welcome_screen.model.data.WelcomeScreenData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 26/3/17.
 */

public class MockWelcome implements WelcomeScreenProvider {
    @Override
    public void getWelcomeData(final WelcomeScreenCallBack welcomeScreenCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                welcomeScreenCallBack.onSuccess(getMockWelcome());
                Log.d("Mock","1");


            }
        },500);
    }
    WelcomeScreenData getMockWelcome()
    {
        List<WelcomeImageDetails> welcomeImageDetailses = new ArrayList<>();
        for (int i=0;i<4;i++)
        {
            WelcomeImageDetails welcomeImageDetails = new WelcomeImageDetails
                    (i+ "","https://drive.google.com/open?id=0BxXB_NzrYajbdGwyZ0NYaXZ1TDQ","Stay Updated");
            welcomeImageDetailses.add(welcomeImageDetails);

        }

        WelcomeScreenData welcomeScreenData = new WelcomeScreenData(true,welcomeImageDetailses,"Success");
        return welcomeScreenData;

    }
}
