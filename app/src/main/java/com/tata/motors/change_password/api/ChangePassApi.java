package com.tata.motors.change_password.api;

import com.tata.motors.change_password.model.data.ChangePassData;
import com.tata.motors.helper.Urls;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 5/3/17.
 */
public interface ChangePassApi {

    @GET(Urls.REQUEST_CHANGE_PASS)
    Call<ChangePassData> changePassword(@Query("access_token")String token,
                                        @Query("old_password")String oldPassword,
                                        @Query("new_password")String newPassword );




}



