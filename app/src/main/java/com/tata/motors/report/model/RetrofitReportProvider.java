package com.tata.motors.report.model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tata.motors.helper.Urls;
import com.tata.motors.report.api.RequestReport;
import com.tata.motors.report.model.data.ReportData;
import com.tata.motors.report.view.OnReportReceived;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by iket on 19/10/16.
 */
public class RetrofitReportProvider implements ReportProvider {
    private RequestReport requestReport;

    public RetrofitReportProvider() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .build();


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        requestReport = retrofit.create(RequestReport.class);

    }


    @Override
    public void getReport(String access_token, final OnReportReceived onReportReceived) {
        Call<ReportData> call = requestReport.getReport(access_token);
        call.enqueue(new Callback<ReportData>() {
            @Override
            public void onResponse(Call<ReportData> call, Response<ReportData> response) {
                onReportReceived.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ReportData> call, Throwable t) {
                onReportReceived.onFailure();
                t.printStackTrace();
            }
        });


    }
}
