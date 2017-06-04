package com.executives.motors.change_password.api;

import com.executives.motors.change_password.model.data.ChangePassData;
import com.executives.motors.helper.Urls;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by aman on 5/3/17.
 */
public interface ChangePassApi {


    @FormUrlEncoded
    @POST(Urls.REQUEST_CHANGE_PASS)
    Call<ChangePassData> changePassword(@Field("access_token") String token,
                                        @Field("password") String oldPassword,
                                        @Field("new_password") String newPassword );




}



