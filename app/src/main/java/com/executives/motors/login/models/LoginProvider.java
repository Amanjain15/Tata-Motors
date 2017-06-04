package com.executives.motors.login.models;


import com.executives.motors.login.LoginCallback;

/**
 * Created by aman on 15/10/16.
 */
public interface LoginProvider {

    void requestLogin(String name, String password, LoginCallback loginUsCallback);

}
