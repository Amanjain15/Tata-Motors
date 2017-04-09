package com.tata.motors.profile.api;

import com.tata.motors.helper.Urls;
import com.tata.motors.profile.model.data.ProfileSendData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 26/1/17.
 */
public interface ProfileSendApi {

@GET(Urls.REQUEST_SEND_PROFILE)
Call<ProfileSendData> requestSendData(@Query("access_token")String token,
                                      @Query("user_name")String userName,
                                       @Query("name")String sendName,
                                      @Query("mobile") String sendMobileNo,
                                      @Query("email") String sendEmail,
                                      @Query("address") String sendAddress,
                                       @Query("designation") String designation,
                                      @Query("dealer") String dealer);

}
