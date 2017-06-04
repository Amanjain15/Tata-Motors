package com.executives.motors.set_achievement.api;

import com.executives.motors.helper.Urls;
import com.executives.motors.set_achievement.model.data.SendAchiData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 11/4/17.
 */

public interface SendAchiApi {
    @GET(Urls.SEND_ACHI)
    Call<SendAchiData> SendAchi(@Query("access_token")String token, @Query("id")int id,@Query("achievement")String achievement);



}
