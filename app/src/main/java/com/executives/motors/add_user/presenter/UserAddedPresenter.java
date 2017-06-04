package com.executives.motors.add_user.presenter;

/**
 * Created by aman on 24/1/17.
 */

public interface UserAddedPresenter {

    void responseAddUser(String access_token,int dealer_id,String key_employee_type, String username,String name);
}
