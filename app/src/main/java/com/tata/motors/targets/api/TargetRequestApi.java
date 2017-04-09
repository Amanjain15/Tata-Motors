package com.tata.motors.targets.api;

import com.tata.motors.helper.Urls;
import com.tata.motors.targets.model.data.TargetData;
import com.tata.motors.targets.model.data.TargetDataTsm;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 6/3/17.
 */

public interface TargetRequestApi {

    @GET(Urls.REQUEST_TARGET)
    Call<TargetData> requestTarget(@Query("user_type")String user_type,
                                   @Query("user_id")int user_id,
                                   @Query("username") String username);

}