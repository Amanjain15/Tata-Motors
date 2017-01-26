package com.tata.motors.add_user.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tata.motors.add_user.AddUserCallBack;
import com.tata.motors.add_user.api.AddUserRequestApi;
import com.tata.motors.add_user.model.data.AddUserData;
import com.tata.motors.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 23/1/17.
 */

public class AddUserRetrofitProvider implements AddUserProvider{

    private AddUserRequestApi addUserRequestApi;
    private Retrofit retrofit;

    @Override
    public void requestAddUser(String access_token, String user_id, String user_type,
                               String key_employee_type,
                               final AddUserCallBack addUserCallBack) {

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

        addUserRequestApi = retrofit.create(AddUserRequestApi.class);
        Call<AddUserData> addUserDataCall= addUserRequestApi.requestAddUser(access_token,
                                                    user_id,user_type, key_employee_type);

        addUserDataCall.enqueue(new Callback<AddUserData>() {
            @Override
            public void onResponse(Call<AddUserData> call, Response<AddUserData> response) {
                addUserCallBack.onSuccess(response.body())  ;
            }

            @Override
            public void onFailure(Call<AddUserData> call, Throwable t) {

                t.printStackTrace();
                addUserCallBack.onFailure();
            }
        });



    }


}
