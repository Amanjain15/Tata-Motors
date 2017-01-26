package com.tata.motors.report.api;




import com.tata.motors.helper.Urls;
import com.tata.motors.report.model.data.ReportData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by iket on 19/10/16.
 */
public interface RequestReport {
    @GET(Urls.REPORT)
    Call<ReportData> getReport(@Query("access_token") String access_token);
}
