package com.executives.motors.splash_screen.api;

import com.executives.motors.helper.Urls;
import com.executives.motors.splash_screen.model.data.SplashScreenData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aman on 12/12/16.
 */

public interface SplashScreenRequestApi {


    @GET(Urls.REQUEST_SPLASH_SCREEN)
    Call<SplashScreenData> requestSplash();
}
