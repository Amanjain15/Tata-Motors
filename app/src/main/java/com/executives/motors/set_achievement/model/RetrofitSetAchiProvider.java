package com.executives.motors.set_achievement.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.executives.motors.helper.Urls;
import com.executives.motors.set_achievement.SendAchiCallBack;
import com.executives.motors.set_achievement.SetAchiCallBack;
import com.executives.motors.set_achievement.api.SendAchiApi;
import com.executives.motors.set_achievement.api.SetAchiApi;
import com.executives.motors.set_achievement.model.data.SendAchiData;
import com.executives.motors.set_achievement.model.data.SetAchiData;

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

public class RetrofitSetAchiProvider implements SetAchiProvider{
private SetAchiApi setAchiApi;
    private SendAchiApi sendAchiApi;
    public RetrofitSetAchiProvider() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        setAchiApi=retrofit.create(SetAchiApi.class);

sendAchiApi=retrofit.create(SendAchiApi.class);


    }

    @Override
    public void sendAchi(String access_token, int id, String achievement, final SendAchiCallBack sendAchiCallBack) {
        Call<SendAchiData>call=sendAchiApi.SendAchi(access_token,id,achievement);
        call.enqueue(new Callback<SendAchiData>() {
            @Override
            public void onResponse(Call<SendAchiData> call, Response<SendAchiData> response) {
                sendAchiCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SendAchiData> call, Throwable throwable) {
sendAchiCallBack.onFailure();
                throwable.printStackTrace();
            }
        });
    }

    @Override
    public void requestSpinner(String access_token, final SetAchiCallBack setAchiCallBack) {
        Call<SetAchiData>call=setAchiApi.requestAchi(access_token);
        call.enqueue(new Callback<SetAchiData>() {
            @Override
            public void onResponse(Call<SetAchiData> call, Response<SetAchiData> response) {
                setAchiCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SetAchiData> call, Throwable throwable) {

                setAchiCallBack.onFailure();
                throwable.printStackTrace();

            }
        });






    }
}
