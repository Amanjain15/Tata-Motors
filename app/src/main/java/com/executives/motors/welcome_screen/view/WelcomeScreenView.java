package com.executives.motors.welcome_screen.view;


import com.executives.motors.welcome_screen.model.data.WelcomeImageDetails;

import java.util.List;

/**
 * Created by aman on 30/12/16.
 */

public interface WelcomeScreenView {

    void showMessage(String error);
    void showProgressBar(boolean show);
    void setData(List<WelcomeImageDetails> welcomeImageDetails);

}
