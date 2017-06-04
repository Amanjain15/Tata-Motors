package com.executives.motors.targets.api;

import com.executives.motors.helper.Urls;
import com.executives.motors.targets.model.data.TargetData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 6/3/17.
 */

public interface TargetRequestApi {

    @GET(Urls.REQUEST_TARGET)
    Call<TargetData> requestTarget(@Query("access_token")String user_type);

}