package com.executives.motors.follow_up.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.executives.motors.follow_up.FollowUpCallBack;
import com.executives.motors.follow_up.api.FollowUpApi;
import com.executives.motors.follow_up.model.data.FollowUpData;
import com.executives.motors.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 11/4/17.
 */

public class RerofitFollowUpProvider implements FollowUpProvider {

    private Retrofit retrofit;
    private FollowUpApi followUpApi;

    @Override
    public void requestFollowUp(String access_token, int customer_id, final FollowUpCallBack followUpCallBack) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client= new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson= new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        followUpApi = retrofit.create(FollowUpApi.class);
        Call<FollowUpData> call = followUpApi.requestFollow(access_token,customer_id);
        call.enqueue(new Callback<FollowUpData>() {
            @Override
            public void onResponse(Call<FollowUpData> call, Response<FollowUpData> response) {
                followUpCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<FollowUpData> call, Throwable t) {
                t.printStackTrace();
                followUpCallBack.Failure("Unable to Connect");
            }
        });

    }
}
