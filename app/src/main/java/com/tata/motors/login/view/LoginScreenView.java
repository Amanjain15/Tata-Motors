package com.tata.motors.login.view;

import com.tata.motors.login.models.data.LoginData;

/**
 * Created by aman on 15/10/16.
 */
public interface LoginScreenView {


    void showLoading(boolean show);

    void showMessage(String message);

    void onLoginVerified(LoginData loginData);


}

