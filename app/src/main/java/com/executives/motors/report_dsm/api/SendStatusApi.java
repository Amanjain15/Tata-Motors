package com.executives.motors.report_dsm.api;

import com.executives.motors.helper.Urls;
import com.executives.motors.report_dsm.model.data.StatusData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by aman on 12/4/17.
 */

public interface SendStatusApi {

    @FormUrlEncoded
    @POST(Urls.SEND_STATUS)
    Call<StatusData> sendStatus(@Field("access_token") String token, @Field("id") int id);



}
