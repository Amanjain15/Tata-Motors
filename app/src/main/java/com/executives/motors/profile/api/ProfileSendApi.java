package com.executives.motors.profile.api;

import com.executives.motors.helper.Urls;
import com.executives.motors.profile.model.data.ProfileSendData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by aman on 26/1/17.
 */
public interface ProfileSendApi {

@FormUrlEncoded
@POST(Urls.REQUEST_SEND_PROFILE)
Call<ProfileSendData> requestSendData(@Field("access_token") String token,
                                      @Field("user_id")int userId,
                                       @Field("name")String sendName,
                                      @Field("mobile") String sendMobileNo,
                                      @Field("email") String sendEmail,
                                      @Field("address") String sendAddress,
                                       @Field("designation") String designation);

}
// "profile_image"