package com.executives.motors.welcome_screen.presenter;

import com.executives.motors.welcome_screen.WelcomeScreenCallBack;
import com.executives.motors.welcome_screen.model.WelcomeScreenProvider;
import com.executives.motors.welcome_screen.model.data.WelcomeScreenData;
import com.executives.motors.welcome_screen.view.WelcomeScreenView;

/**
 * Created by aman on 30/12/16.
 */

public class WelcomeScreenPresenterImpl implements WelcomeScreenPresenter{

    private WelcomeScreenView welcomeScreenView;
    private WelcomeScreenProvider welcomeScreenProvider;

    public WelcomeScreenPresenterImpl(WelcomeScreenView welcomeScreenView, WelcomeScreenProvider welcomeScreenProvider) {
        this.welcomeScreenView = welcomeScreenView;
        this.welcomeScreenProvider = welcomeScreenProvider;
    }

    @Override
    public void getWelcomeData() {
        welcomeScreenProvider.getWelcomeData(new WelcomeScreenCallBack() {
            @Override
            public void onSuccess(WelcomeScreenData welcomeScreenData) {
                if (welcomeScreenData.isSuccess()){

                    welcomeScreenView.setData(welcomeScreenData.getSlider_data());
                    welcomeScreenView.showProgressBar(false);
                    welcomeScreenView.showMessage("Success");

                }
                else{
                    welcomeScreenView.showProgressBar(true);
                    welcomeScreenView.showMessage("Something went wrong");

                }
            }

            @Override
            public void onFailure(String error) {
                welcomeScreenView.showMessage("Failed");
                welcomeScreenView.showProgressBar(false);
            }
        });
    }
}
