package com.tata.motors.splash_screen.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tata.motors.helper.Urls;
import com.tata.motors.splash_screen.SplashScreenCallBack;
import com.tata.motors.splash_screen.api.SplashScreenRequestApi;
import com.tata.motors.splash_screen.model.data.SplashScreenData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by aman on 12/12/16.
 */

public class RetrofitSplashScreenProvider implements SplashScreenProvider{

    private static final String TAG = "RetrofitSplashScreen";
    private static final String LOG_TAG = "SplashScreenActivity";
    private SplashScreenRequestApi splashScreenRequestApi;


    @Override
    public void requestSplash(final SplashScreenCallBack splashScreenCallBack) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        splashScreenRequestApi = retrofit.create(SplashScreenRequestApi.class);
        Call<SplashScreenData> call = splashScreenRequestApi.requestSplash();
        call.enqueue(new Callback<SplashScreenData>() {
            @Override
            public void onResponse(Call<SplashScreenData> call, Response<SplashScreenData> response) {
                splashScreenCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SplashScreenData> call, Throwable t) {
                t.printStackTrace();
                splashScreenCallBack.onFailure("Unable to Connect");

            }
        });

    }
}
