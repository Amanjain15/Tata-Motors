package com.executives.motors.welcome_screen.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.executives.motors.helper.Urls;
import com.executives.motors.welcome_screen.WelcomeScreenCallBack;
import com.executives.motors.welcome_screen.api.WelcomeScreenRequestApi;
import com.executives.motors.welcome_screen.model.data.WelcomeScreenData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 30/12/16.
 */

public class RetrofitWelcomeScreenProvider implements WelcomeScreenProvider {

    private WelcomeScreenRequestApi welcomeScreenRequestApi;
    private Retrofit retrofit;

    public RetrofitWelcomeScreenProvider()
    {
        Gson gson=new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }


    @Override
    public void getWelcomeData(final WelcomeScreenCallBack welcomeScreenCallBack) {

        welcomeScreenRequestApi =retrofit.create(WelcomeScreenRequestApi.class);
        Call<WelcomeScreenData> call = welcomeScreenRequestApi.getWelcomeData();

        call.enqueue(new Callback<WelcomeScreenData>() {
            @Override
            public void onResponse(Call<WelcomeScreenData> call, Response<WelcomeScreenData> response) {
                welcomeScreenCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<WelcomeScreenData> call, Throwable t) {
                t.printStackTrace();
                welcomeScreenCallBack.onFailure("Unable to Connect");
            }
        });


    }
}
