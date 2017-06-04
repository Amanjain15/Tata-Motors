package com.executives.motors.login.api;

import com.executives.motors.helper.Urls;
import com.executives.motors.login.models.data.LoginData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Created by aman on 15/10/16.
 */
public interface LoginApi {

    @FormUrlEncoded
    @POST(Urls.REQUEST_LOGIN)
    Call<LoginData> requestLogin(@Field("user_name") String name, @Field("password")String password);


}


