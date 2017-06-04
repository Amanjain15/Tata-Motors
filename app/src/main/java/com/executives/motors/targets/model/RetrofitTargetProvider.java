package com.executives.motors.targets.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.executives.motors.helper.Urls;
import com.executives.motors.targets.ResponseTargetCallBack;
import com.executives.motors.targets.SetTargetCallBack;
import com.executives.motors.targets.TargetCallBack;
import com.executives.motors.targets.api.SetTargetRequestApi;
import com.executives.motors.targets.api.SetTargetResponseApi;
import com.executives.motors.targets.api.TargetRequestApi;
import com.executives.motors.targets.model.data.TargetData;
import com.executives.motors.targets.model.data.TargetDataTsm;
import com.executives.motors.targets.model.data.TargetResponseData;

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
    private SetTargetRequestApi setTargetRequestApi;
    private SetTargetResponseApi setTargetResponseApi;
    private Retrofit retrofit;

    @Override
    public void requestTarget(String access_token, final TargetCallBack targetCallBack) {
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
        Call<TargetData> call = targetRequestApi.requestTarget(access_token);
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

    @Override
    public void requestSetTarget(int user_id, String username, final SetTargetCallBack setTargetCallBack) {
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
        setTargetRequestApi = retrofit.create(SetTargetRequestApi.class);
        Call<TargetDataTsm> call = setTargetRequestApi.requestSetTarget(user_id,username);
        call.enqueue(new Callback<TargetDataTsm>() {
            @Override
            public void onResponse(Call<TargetDataTsm> call, Response<TargetDataTsm> response) {
                setTargetCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<TargetDataTsm> call, Throwable t) {
                t.printStackTrace();
                setTargetCallBack.onFailure("Unable to Connect");

            }
        });
    }

    @Override
    public void responseSetTarget(String access_token, int user_id, String username,
                                  String monthly, String daily,
                                  final ResponseTargetCallBack responseTargetCallBack) {
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
        setTargetResponseApi = retrofit.create(SetTargetResponseApi.class);
        Call<TargetResponseData> call = setTargetResponseApi.responseSetTarget(access_token,
                                        user_id,username,monthly,daily);
        call.enqueue(new Callback<TargetResponseData>() {
            @Override
            public void onResponse(Call<TargetResponseData> call, Response<TargetResponseData> response) {
                responseTargetCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<TargetResponseData> call, Throwable t) {
                responseTargetCallBack.onFailure("Unable to Connect");
            }
        });


    }
}
