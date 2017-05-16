package com.tata.motors.set_achievement.api;

import com.tata.motors.helper.Urls;
import com.tata.motors.set_achievement.model.data.SendAchiData;
import com.tata.motors.set_achievement.model.data.SetAchiData;

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
