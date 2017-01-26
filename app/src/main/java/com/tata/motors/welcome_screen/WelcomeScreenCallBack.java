package com.tata.motors.welcome_screen;

import com.tata.motors.welcome_screen.model.data.WelcomeScreenData;

/**
 * Created by aman on 14/12/16.
 */

public interface WelcomeScreenCallBack {

    void onSuccess(WelcomeScreenData welcomeScreenData);
    void onFailure (String error);
}
