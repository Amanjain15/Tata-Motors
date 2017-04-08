package com.tata.motors.add_user.presenter;

import com.tata.motors.add_user.AddUserCallBack;

/**
 * Created by aman on 23/1/17.
 */

public interface AddUserPresenter {

    void requestAddUser(String access_token, String user_id,
                        String key_employee_type);
}
