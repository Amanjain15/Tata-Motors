package com.executives.motors.splash_screen.view;

import com.executives.motors.splash_screen.model.data.SplashScreenData;

/**
 * Created by aman on 12/12/16.
 */

public interface SplashScreenView {

    void showMessage(String message);

    void showProgressBar(boolean show);

    void hideProgressBar();

    void version_check(SplashScreenData splashScreenData);


}
