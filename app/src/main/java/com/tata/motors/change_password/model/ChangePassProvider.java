package com.tata.motors.change_password.model;

import com.tata.motors.change_password.ChangePassCallBack;

/**
 * Created by aman on 5/3/17.
 */
public interface ChangePassProvider {

    void requestChangePass(String token, String oldPassword, String newPassword, ChangePassCallBack changePassCallBack);

}
