package com.tata.motors.change_password.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tata.motors.change_password.ChangePassCallBack;
import com.tata.motors.change_password.api.ChangePassApi;
import com.tata.motors.change_password.model.data.ChangePassData;
import com.tata.motors.employee.api.EmployeeApi;
import com.tata.motors.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 5/3/17.
 */
public class RetrofitChangePassProvider implements ChangePassProvider {
public ChangePassApi changePassApi;
    public ChangePassProvider changePassProvider;

    public RetrofitChangePassProvider() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        changePassApi = retrofit.create(ChangePassApi.class);
    }

    @Override
    public void requestChangePass(String token, String oldPassword, String newPassword,
                                  final ChangePassCallBack changePassCallBack)

    {
        Call<ChangePassData>call=changePassApi.changePassword(token,oldPassword,newPassword);
        call.enqueue(new Callback<ChangePassData>() {
            @Override
            public void onResponse(Call<ChangePassData> call, Response<ChangePassData> response) {
                changePassCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ChangePassData> call, Throwable t) {

                   t.printStackTrace();
                changePassCallBack.onFailure();
                 }
        });





    }
}
