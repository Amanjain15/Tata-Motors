package com.executives.motors.add_user.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.executives.motors.add_user.UserAddedCallBack;
import com.executives.motors.add_user.api.AddUserResponseApi;
import com.executives.motors.add_user.model.data.UserAddedData;
import com.executives.motors.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 24/1/17.
 */

public class UserAddedRetrofitProvider implements UserAddedProvider {

    private AddUserResponseApi addUserResponseApi;
    private Retrofit retrofit;


    @Override
    public void responseAddUser(String access_token,int dealer_id, String username, String name,
                                String key_employee_type,final UserAddedCallBack userAddedCallBack)

    {

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
        addUserResponseApi = retrofit.create(AddUserResponseApi.class);

        final Call<UserAddedData> userAddedDataCall = addUserResponseApi.responseAddUser(access_token
                ,dealer_id,username,name,key_employee_type);

        userAddedDataCall.enqueue(new Callback<UserAddedData>() {
            @Override
            public void onResponse(Call<UserAddedData> call, Response<UserAddedData> response) {
                userAddedCallBack.onSuccess(response.body());

            }

            @Override
            public void onFailure(Call<UserAddedData> call, Throwable t) {

                t.printStackTrace();
                userAddedCallBack.onFailure("");
            }
        });



    }
}
