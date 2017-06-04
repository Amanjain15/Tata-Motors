package com.executives.motors.add_user.model;

import com.executives.motors.add_user.UserAddedCallBack;

/**
 * Created by aman on 24/1/17.
 */

public interface UserAddedProvider {


    void responseAddUser(String access_token,int dealer_id, String username, String name,
                         String key_employee_type,
                         UserAddedCallBack userAddedCallBack);

}


