package com.tata.motors.add_user.api;

import com.tata.motors.add_user.model.data.AddUserData;
import com.tata.motors.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 23/1/17.
 */

public interface AddUserRequestApi {

    @GET(Urls.REQUEST_ADD_USER)
    Call<AddUserData> requestAddUser(@Query("access_token") String access_token,
                                     @Query("user_id") String user_id,
                                     @Query("user_type") String user_type,
                                     @Query("employee") String key_employee_type
                                        );

}
