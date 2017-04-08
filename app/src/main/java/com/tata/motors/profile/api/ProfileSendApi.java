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
                                      @Query("user_id")int sendUserId, @Query("name")String sendName,
                                      @Query("mobile_no") String sendMobileNo,
                                      @Query("contact_no") String sendContactNo,
                                      @Query("email") String sendEmail,
                                      @Query("address") String sendAddress );

}
