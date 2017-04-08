package com.tata.motors.report_tsm.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tata.motors.helper.Urls;
import com.tata.motors.report.api.RequestReport;
import com.tata.motors.report_tsm.ReportTsmCallBack;
import com.tata.motors.report_tsm.api.ReportTsmapi;
import com.tata.motors.report_tsm.model.data.ReportTsmData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 8/3/17.
 */
public class RetrofitReportTsmProvider implements ReportTsmProvider {
private ReportTsmapi reportTsmapi;
    public RetrofitReportTsmProvider() {
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
        reportTsmapi = retrofit.create(ReportTsmapi.class);



    }

    @Override
    public void requestTsmReport(String token,String userType,String dsmId,String dseId, final  ReportTsmCallBack reportTsmCallBack) {
        Call<ReportTsmData>call=reportTsmapi.requestReportTsm(token,userType,dseId,dsmId);
        call.enqueue(new Callback<ReportTsmData>() {
            @Override
            public void onResponse(Call<ReportTsmData> call, Response<ReportTsmData> response) {
                reportTsmCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ReportTsmData> call, Throwable t) {
                reportTsmCallBack.onFailure();
                t.printStackTrace();


            }
        });






    }
}
