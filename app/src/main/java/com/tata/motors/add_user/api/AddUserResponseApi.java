package com.tata.motors.add_user.api;

import com.tata.motors.add_user.model.data.UserAddedData;
import com.tata.motors.helper.Urls;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by aman on 24/1/17.
 */

public interface AddUserResponseApi {

    @FormUrlEncoded
    @POST(Urls.RESPONSE_ADD_USER)
    Call<UserAddedData> responseAddUser(@Field("dealer_id") String dealer_id,
                                        @Field("dsm_id") String dsm_id,
                                        @Field("username") String username,
                                        @Field("name") String name);
}
