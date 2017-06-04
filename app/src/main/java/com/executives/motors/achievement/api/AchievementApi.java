package com.executives.motors.achievement.api;

import com.executives.motors.achievement.model.data.AchievementData;
import com.executives.motors.helper.Urls;

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
