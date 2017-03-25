package com.tata.motors.report_tsm.api;

import com.tata.motors.helper.Urls;
import com.tata.motors.report_tsm.model.data.ReportTsmData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 8/3/17.
 */
public interface ReportTsmapi {
    @GET(Urls.REQUEST_REPORT_TSM)
    Call<ReportTsmData> requestReportTsm(@Query("access_token") String token,@Query("user_type")String usrType,@Query("dsm_id")String dsmId,@Query("dse_id")String dseId);
}



