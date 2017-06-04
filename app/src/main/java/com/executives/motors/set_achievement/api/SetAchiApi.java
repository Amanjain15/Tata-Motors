package com.executives.motors.set_achievement.api;

import com.executives.motors.helper.Urls;
import com.executives.motors.set_achievement.model.data.SetAchiData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 9/4/17.
 */

public interface SetAchiApi {
    @GET(Urls.SET_ACHI)
    Call<SetAchiData> requestAchi(@Query("access_token")String token);

}
