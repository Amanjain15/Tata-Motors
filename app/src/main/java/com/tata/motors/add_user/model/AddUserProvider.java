package com.tata.motors.add_user.model;

import com.tata.motors.add_user.AddUserCallBack;

/**
 * Created by aman on 23/1/17.
 */

public interface AddUserProvider {

    void requestAddUser(String access_token, int user_id,
                        String key_employee_type,AddUserCallBack addUserCallBack);
}
