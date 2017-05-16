package com.tata.motors.employee.model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tata.motors.employee.EmployeeCallBack;
import com.tata.motors.employee.SendStatusCallBack;
import com.tata.motors.employee.api.EmployeeApi;
import com.tata.motors.employee.model.data.EmployeeData;
import com.tata.motors.employee.model.data.StatusData;
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
    public void requestEmployee(String token, int choose_id,String user_c_type,
                                String to_date,String from_date,int choice,
                                final EmployeeCallBack employeeCallBack) {

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
        Call<EmployeeData> call = employeeApi.getemployee(token,choose_id,user_c_type,to_date,from_date,choice);
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

    @Override
    public void sendStatus(String access_token, int id, final SendStatusCallBack sendStatusCallBack) {
        Log.d("safeCall","Reached Retrofit");
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
        Call<StatusData> call = employeeApi.sendStatus(access_token,id);
        call.enqueue(new Callback<StatusData>() {
            @Override
            public void onResponse(Call<StatusData> call, Response<StatusData> response) {
                sendStatusCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<StatusData> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }
}

