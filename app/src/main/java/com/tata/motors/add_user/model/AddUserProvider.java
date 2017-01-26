package com.tata.motors.add_user.model;

import com.tata.motors.add_user.AddUserCallBack;

/**
 * Created by aman on 23/1/17.
 */

public interface AddUserProvider {

    void requestAddUser(String access_token, String user_id, String user_type,
                        String key_employee_type,AddUserCallBack addUserCallBack);
}
