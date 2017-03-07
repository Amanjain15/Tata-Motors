package com.tata.motors.change_password.api;

import com.tata.motors.helper.Urls;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 5/3/17.
 */
public class ChangePassApi {
    @GET(Urls.REQUEST_CHANGE_PASS)
    Call<Response> changePassword(@Query("accesstoken")String token, @Query("oldpassword")String oldPassword, @Query("newpassword")String newPassword );




}



