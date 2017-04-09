package com.tata.motors.add_customer.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tata.motors.add_customer.AddCustomerCallback;
import com.tata.motors.add_customer.api.AddCustomerRequestApi;
import com.tata.motors.add_customer.model.data.AddCustomerData;
import com.tata.motors.add_customer.model.data.CustomerAddedData;
import com.tata.motors.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 27/1/17.
 */

public class RetrofitAddCustomerProvider implements AddCustomerProvider{

    private AddCustomerRequestApi addCustomerRequestApi;
    private Retrofit retrofit;




    @Override
    public void requestAddCustomer(String acces_token, int user_id, String user_type,
                                   final AddCustomerCallback addCustomerCallback) {
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
        addCustomerRequestApi= retrofit.create(AddCustomerRequestApi.class);
        Call<AddCustomerData> call= addCustomerRequestApi.requestAddCustomer(acces_token,user_id,user_type);
        call.enqueue(new Callback<AddCustomerData>() {
            @Override
            public void onResponse(Call<AddCustomerData> call, Response<AddCustomerData> response) {
                addCustomerCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<AddCustomerData> call, Throwable t) {
                    t.printStackTrace();
                    addCustomerCallback.onFailure("Unable to connect");
            }
        });

    }
}
