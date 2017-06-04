package com.executives.motors.add_user.presenter;

/**
 * Created by aman on 23/1/17.
 */

public interface AddUserPresenter {

    void requestAddUser(String access_token, int user_id,
                        String key_employee_type);
}
