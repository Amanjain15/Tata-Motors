package com.tata.motors.targets.api;

import com.tata.motors.helper.Urls;
import com.tata.motors.targets.model.data.TargetDataTsm;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 13/3/17.
 */

public interface SetTargetRequestApi {

    @GET(Urls.REQUEST_SET_TARGET)
    Call<TargetDataTsm> requestSetTarget(@Query("user_id")String user_id,
                                         @Query("username") String username);
}
