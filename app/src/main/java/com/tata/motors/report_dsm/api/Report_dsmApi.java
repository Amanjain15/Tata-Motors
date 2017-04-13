package com.tata.motors.report_dsm.api;

import com.tata.motors.helper.Urls;
import com.tata.motors.report_dsm.model.data.Report_dsmData;
import com.tata.motors.report_tsm.model.data.ReportTsmData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 12/4/17.
 */

public interface Report_dsmApi {
    @GET(Urls.REQUEST_REPORT_DSM)
    Call<Report_dsmData> requestReportDsm(@Query("access_token") String token, @Query("user_id")int user_id,//user_id==upar bande ki
                                          @Query("user_see_type") int type);//jiska mangwana hai



}
