package com.tata.motors.add_customer.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tata.motors.add_customer.CustomerAddedCallBack;
import com.tata.motors.add_customer.EditCustomerCallBack;
import com.tata.motors.add_customer.api.EditCustomerApi;
import com.tata.motors.add_customer.model.data.CustomerAddedData;
import com.tata.motors.add_customer.model.data.EditCustomerData;
import com.tata.motors.helper.Urls;
import com.tata.motors.view_customer.model.ViewCustomerProvider;
import com.tata.motors.view_customer.presenter.ViewCustomerPresenter;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 12/4/17.
 */

public class RetrofitEditCustomerProvider implements EditCustomerProvider {


    private EditCustomerApi editCustomerApi;
    private Retrofit retrofit;
    @Override
    public void requestEditCustomer(String access_token, int choose_id, final EditCustomerCallBack editCustomerCallBack) {
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
        editCustomerApi = retrofit.create(EditCustomerApi.class);
        Call<EditCustomerData> call = editCustomerApi.requestEditCustomer(access_token,choose_id);
        call.enqueue(new Callback<EditCustomerData>() {
            @Override
            public void onResponse(Call<EditCustomerData> call, Response<EditCustomerData> response) {
                editCustomerCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<EditCustomerData> call, Throwable t) {
                t.printStackTrace();
                editCustomerCallBack.onFailure("Unable to Connect");
            }
        });
    }

    @Override
    public void responseEditCustomer(String access_token,int dsm_id, int choose_id, String customer_name,
                                     String address,String email, String application_name, String contact_no,
                                     String district_name, String town_name, String tehsil, String json,
                                     String financier_name, String follow_up, int status, String location,
                                     final CustomerAddedCallBack customerAddedCallBack) {
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
        editCustomerApi =retrofit.create(EditCustomerApi.class);
        Call<CustomerAddedData> call = editCustomerApi.responseEditCustomer(access_token,dsm_id,
                choose_id,customer_name,address,email,application_name,contact_no, district_name,
                town_name, tehsil,json, financier_name, follow_up,
                status,location);
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
