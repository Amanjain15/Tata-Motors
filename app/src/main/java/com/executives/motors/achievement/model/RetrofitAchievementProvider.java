package com.executives.motors.achievement.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.executives.motors.achievement.AchievementCallBack;
import com.executives.motors.achievement.api.AchievementApi;
import com.executives.motors.achievement.model.data.AchievementData;
import com.executives.motors.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 9/4/17.
 */

public class RetrofitAchievementProvider implements AchievementProvider {


    private AchievementApi achievementApi;

    public RetrofitAchievementProvider() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        achievementApi = retrofit.create(AchievementApi.class);
    }
    @Override
    public void requestAchievement(String access_token, final AchievementCallBack achievementCallBack) {
        Call<AchievementData> call=achievementApi.requestAchievement(access_token);
        call.enqueue(new Callback<AchievementData>() {
            @Override
            public void onResponse(Call<AchievementData> call, Response<AchievementData> response) {
                achievementCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<AchievementData> call, Throwable t) {
                              achievementCallBack.onFailure();
                t.printStackTrace();
            }
        });








    }
}
