package com.tata.motors.view_customer.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tata.motors.helper.Urls;
import com.tata.motors.view_customer.ViewCustomerCallBack;
import com.tata.motors.view_customer.api.ViewCustomerApi;
import com.tata.motors.view_customer.model.data.ViewCustomerData;

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

public class RetrofitViewCustomerProvider implements ViewCustomerProvider {

    private ViewCustomerApi viewCustomerApi;
    private Retrofit retrofit;

    @Override
    public void requestViewCustomer(String access_token, int customer_id, final ViewCustomerCallBack viewCustomerCallBack) {

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
        viewCustomerApi= retrofit.create(ViewCustomerApi.class);
        Call<ViewCustomerData> call = viewCustomerApi.requestViewCustomer(access_token,customer_id);
        call.enqueue(new Callback<ViewCustomerData>() {
            @Override
            public void onResponse(Call<ViewCustomerData> call, Response<ViewCustomerData> response) {
                viewCustomerCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ViewCustomerData> call, Throwable t) {
                t.printStackTrace();
                viewCustomerCallBack.onFailure("Unable to Connect");
            }
        });


    }
}
