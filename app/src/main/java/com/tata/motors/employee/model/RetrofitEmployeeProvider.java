package com.tata.motors.employee.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tata.motors.employee.EmployeeCallBack;
import com.tata.motors.employee.api.EmployeeApi;
import com.tata.motors.employee.model.data.EmployeeData;
import com.tata.motors.helper.Urls;


import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 24/1/17.
 */
public class RetrofitEmployeeProvider implements EmployeeProvider {
    private EmployeeApi employeeApi;
    private EmployeeCallBack employeeCallBack;

//    public RetrofitEmployeeProvider() {
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Urls.BASE_URL)
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
//        employeeApi = retrofit.create(EmployeeApi.class);
//    }

    @Override
    public void requestEmployee(String token, String Employee, final EmployeeCallBack employeeCallBack) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        employeeApi = retrofit.create(EmployeeApi.class);

        Call<EmployeeData>call = employeeApi.getemployee(token,Employee);
            call.enqueue(new Callback<EmployeeData>() {
                @Override
                public void onResponse(Call<EmployeeData> call, Response<EmployeeData> response) {
                    employeeCallBack.onSuccess(response.body());
                }

                @Override
                public void onFailure(Call<EmployeeData> call, Throwable t) {
                    employeeCallBack.onFailure();
                    t.printStackTrace();
                }
            });
        }
    }

