package com.tata.motors.welcome_screen.api;

import com.tata.motors.helper.Urls;
import com.tata.motors.welcome_screen.model.data.WelcomeScreenData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aman on 30/12/16.
 */

public interface WelcomeScreenRequestApi {

    @GET(Urls.REQUEST_WELCOME_SCREEN)
    Call<WelcomeScreenData> getWelcomeData();
}
