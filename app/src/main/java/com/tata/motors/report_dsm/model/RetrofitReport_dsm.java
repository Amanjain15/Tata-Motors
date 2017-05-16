package com.tata.motors.report_dsm.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tata.motors.helper.Urls;
import com.tata.motors.report_dsm.Report_dsmCallBack;
import com.tata.motors.report_dsm.SendStatusCallBack;
import com.tata.motors.report_dsm.api.Report_dsmApi;
import com.tata.motors.report_dsm.api.SendStatusApi;
import com.tata.motors.report_dsm.model.data.Report_dsmData;
import com.tata.motors.report_dsm.model.data.StatusData;
import com.tata.motors.report_tsm.api.ReportTsmapi;

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

public class RetrofitReport_dsm implements Report_dsmProvider {
    private Report_dsmApi report_dsmApi;
private SendStatusApi sendStatusApi;
    public RetrofitReport_dsm() {
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
        report_dsmApi = retrofit.create(Report_dsmApi.class);
        sendStatusApi=retrofit.create(SendStatusApi.class);
    }


    @Override
    public void requestDsm(String access_token, int user_id,int type, final Report_dsmCallBack report_dsmCallBack) {
        Call<Report_dsmData>call=report_dsmApi.requestReportDsm(access_token,user_id,type);
        call.enqueue(new Callback<Report_dsmData>() {
            @Override
            public void onResponse(Call<Report_dsmData> call, Response<Report_dsmData> response) {
                report_dsmCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Report_dsmData> call, Throwable throwable) {
                   report_dsmCallBack.onFailure();
                throwable.printStackTrace();
            }
        });
    }


    @Override
    public void sendStatus(String access_token, int id, final SendStatusCallBack sendStatusCallBack) {
        Call<StatusData>call=sendStatusApi.sendStatus(access_token,id);
        call.enqueue(new Callback<StatusData>() {
            @Override
            public void onResponse(Call<StatusData> call, Response<StatusData> response) {
                sendStatusCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<StatusData> call, Throwable throwable) {
                  sendStatusCallBack.onFailure();
                throwable.printStackTrace();
            }
        });
    }
}
