package com.tata.motors.achievement.api;

import com.tata.motors.achievement.model.data.AchievementData;
import com.tata.motors.add_customer.model.data.AddCustomerData;
import com.tata.motors.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 9/4/17.
 */

public interface AchievementApi {

    @GET(Urls.REQUEST_ACHIVEMENT)
    Call<AchievementData> requestAchievement(@Query("access_token") String access_token);





}
