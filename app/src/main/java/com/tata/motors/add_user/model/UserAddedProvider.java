package com.tata.motors.add_user.model;

import com.tata.motors.add_user.UserAddedCallBack;

import retrofit2.http.Query;

/**
 * Created by aman on 24/1/17.
 */

public interface UserAddedProvider {


    void responseAddUser(String dealer_id, String dsm_id, String username, String name,
                         UserAddedCallBack userAddedCallBack);

}


