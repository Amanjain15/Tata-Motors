package com.tata.motors.add_customer.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tata.motors.add_customer.CustomerAddedCallBack;
import com.tata.motors.add_customer.api.CustomerAddedResponseApi;
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

public class RetrofitCustomerAddedProvider implements  CustomerAddedProvider{
    private CustomerAddedResponseApi customerAddedResponseApi;
    private Retrofit retrofit;

    @Override
    public void responseAddCustomer(int dsm_id,
                                    int dse_id,
                                    String customer_name,
                                    int application_id,
                                    String contact_no,
                                    int district_id,
                                    int town_id,
                                    String tehsil,
                                    int model_id,
                                    int quantity,
                                    int vehicle_id,
                                    int financier_id,
                                    int follow_up,
                                    int geo_tag, final CustomerAddedCallBack customerAddedCallBack)
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
        customerAddedResponseApi = retrofit.create(CustomerAddedResponseApi.class);
        Call<CustomerAddedData> call = customerAddedResponseApi.responseAddCustomer(
                                dsm_id,dse_id,customer_name, application_id,contact_no, district_id,
                                town_id, tehsil, model_id, quantity,vehicle_id, financier_id, follow_up,
                                geo_tag);
        call.enqueue(new Callback<CustomerAddedData>() {
            @Override
            public void onResponse(Call<CustomerAddedData> call, Response<CustomerAddedData> response) {
                customerAddedCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<CustomerAddedData> call, Throwable t) {
                t.printStackTrace();
                customerAddedCallBack.onFailure("Unable to Connect");
            }
        });


    }
}
