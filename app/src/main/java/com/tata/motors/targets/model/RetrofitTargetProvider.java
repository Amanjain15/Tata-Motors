package com.tata.motors.targets.model;

import android.annotation.TargetApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tata.motors.helper.Urls;
import com.tata.motors.targets.TargetCallBack;
import com.tata.motors.targets.api.TargetRequestApi;
import com.tata.motors.targets.model.data.TargetData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 6/3/17.
 */

public class RetrofitTargetProvider implements TargetProvider{

    private TargetRequestApi targetRequestApi;
    private Retrofit retrofit;

    @Override
    public void requestTarget(String user_id, String username, final TargetCallBack targetCallBack) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        targetRequestApi = retrofit.create(TargetRequestApi.class);
        Call<TargetData> call = targetRequestApi.requestTarget(user_id,username);
        call.enqueue(new Callback<TargetData>() {
            @Override
            public void onResponse(Call<TargetData> call, Response<TargetData> response) {
                targetCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<TargetData> call, Throwable t) {
                t.printStackTrace();
                targetCallBack.onFailure("Unable to Connect");
            }
        });

    }
}
