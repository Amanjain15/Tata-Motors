package com.tata.motors.splash_screen.model;

import android.os.Handler;
import android.util.Log;

import com.tata.motors.splash_screen.SplashScreenCallBack;
import com.tata.motors.splash_screen.model.data.SplashScreenData;

/**
 * Created by aman on 24/3/17.
 */

public class MockSplash implements SplashScreenProvider {
    @Override
    public void requestSplash(final SplashScreenCallBack splashScreenCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                splashScreenCallBack.onSuccess(getMockData());
                Log.d("Mock","1");


            }
        },500);


    }

    SplashScreenData getMockData(){

        SplashScreenData splashScreenData = new SplashScreenData(1,"Received",true,0);
        return splashScreenData;

    }
}
