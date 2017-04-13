package com.tata.motors.follow_up.api;

import com.tata.motors.follow_up.model.data.FollowUpData;
import com.tata.motors.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 11/4/17.
 */

public interface FollowUpApi {

    @GET(Urls.REQUEST_FOLLOW_UP)
    Call<FollowUpData> requestFollow(@Query("access_token") String access_token,
                                       @Query("customer_id") int customer_id);
}
