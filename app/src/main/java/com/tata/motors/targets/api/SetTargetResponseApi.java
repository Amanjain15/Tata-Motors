package com.tata.motors.targets.api;

import com.tata.motors.helper.Urls;
import com.tata.motors.targets.model.data.TargetResponseData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by aman on 4/4/17.
 */

public interface SetTargetResponseApi {

    @FormUrlEncoded
    @POST(Urls.RESPONSE_SET_TARGET)
    Call<TargetResponseData> responseSetTarget(@Field("access_token")String access_token,
                                               @Field("user_id")String user_id,
                                               @Field("username")String user_name,
                                               @Field("monthly")String monthly,
                                               @Field("daily")String daily
                                               );
}
