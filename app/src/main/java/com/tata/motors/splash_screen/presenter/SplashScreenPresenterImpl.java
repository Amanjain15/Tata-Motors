package com.tata.motors.splash_screen.presenter;



import com.tata.motors.splash_screen.SplashScreenCallBack;
import com.tata.motors.splash_screen.model.RetrofitSplashScreenProvider;
import com.tata.motors.splash_screen.model.SplashScreenProvider;
import com.tata.motors.splash_screen.model.data.SplashScreenData;
import com.tata.motors.splash_screen.view.SplashScreenActivity;
import com.tata.motors.splash_screen.view.SplashScreenView;

/**
 * Created by aman on 12/12/16.
 */

public class SplashScreenPresenterImpl implements SplashScreenPresenter {

    private static final String LOG_TAG = "SplashScreenActivity";
    private SplashScreenProvider splashScreenProvider;
    private SplashScreenView splashScreenView;

    public SplashScreenPresenterImpl(SplashScreenActivity splashScreenView,
                                     SplashScreenProvider retrofitSplashScreenProvider) {
        this.splashScreenView = splashScreenView;
        this.splashScreenProvider = retrofitSplashScreenProvider;
    }


    @Override
    public void requestSplash()
    {

        //splashScreenView.showProgressBar(true);
        splashScreenProvider.requestSplash(new SplashScreenCallBack() {
            @Override
            public void onSuccess(SplashScreenData splashScreenData) {


                if(splashScreenData.isSuccess())
                {

                    splashScreenView.version_check(splashScreenData);
                    //splashScreenView.hideProgressBar();
                }
                else
                {
                    splashScreenView.showMessage(splashScreenData.getMessage());
                    //splashScreenView.hideProgressBar();

                }
            }

            @Override
            public void onFailure(String error) {

                //splashScreenView.hideProgressBar();
                splashScreenView.showMessage("No Internet Connection");


            }
        });


    }
}
