package com.tata.motors.change_password.api;

import com.tata.motors.change_password.model.data.ChangePassData;
import com.tata.motors.helper.Urls;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

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



