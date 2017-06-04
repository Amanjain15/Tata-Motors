package com.executives.motors.targets.api;

import com.executives.motors.helper.Urls;
import com.executives.motors.targets.model.data.TargetDataTsm;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 13/3/17.
 */

public interface SetTargetRequestApi {

    @GET(Urls.REQUEST_SET_TARGET)
    Call<TargetDataTsm> requestSetTarget(@Query("user_id")int user_id,
                                         @Query("username") String username);
}
