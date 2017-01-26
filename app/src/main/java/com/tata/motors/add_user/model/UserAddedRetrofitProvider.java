package com.tata.motors.add_user.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tata.motors.add_user.UserAddedCallBack;
import com.tata.motors.add_user.api.AddUserRequestApi;
import com.tata.motors.add_user.api.AddUserResponseApi;
import com.tata.motors.add_user.model.data.UserAddedData;
import com.tata.motors.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

/**
 * Created by aman on 24/1/17.
 */

public class UserAddedRetrofitProvider implements UserAddedProvider {

    private AddUserResponseApi addUserResponseApi;
    private Retrofit retrofit;


    @Override
    public void responseAddUser(String dealer_id,String dsm_id, String username, String name,
                                final UserAddedCallBack userAddedCallBack)

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

        final Call<UserAddedData> userAddedDataCall = addUserResponseApi.responseAddUser(dealer_id,dsm_id,username,name);

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
