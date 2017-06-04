package com.executives.motors.splash_screen;

import com.executives.motors.splash_screen.model.data.SplashScreenData;

/**
 * Created by aman on 12/12/16.
 */

public interface SplashScreenCallBack {

    void onSuccess(SplashScreenData splashScreenData);
    void onFailure(String error);
}
