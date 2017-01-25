package com.tata.motors.login.models;


import com.tata.motors.login.LoginCallback;

/**
 * Created by aman on 15/10/16.
 */
public interface LoginProvider {

    void requestLogin(String name, String password, LoginCallback loginUsCallback);

}
