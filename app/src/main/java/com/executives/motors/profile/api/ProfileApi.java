package com.executives.motors.profile.api;
import com.executives.motors.profile.model.data.ProfileData;
/**
 * Created by aman on 25/1/17.
 */

import com.executives.motors.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface ProfileApi{
@GET(Urls.REQUEST_PROFILE)
Call<ProfileData> requestProfile(@Query("access_token")String token,
                                 @Query("user_id") int user_id

);
}
