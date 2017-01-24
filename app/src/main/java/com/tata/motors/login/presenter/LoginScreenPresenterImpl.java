package com.tata.motors.login.presenter;

import android.util.Log;

import com.tata.motors.login.LoginCallback;
import com.tata.motors.login.models.LoginProvider;
import com.tata.motors.login.models.data.LoginData;
import com.tata.motors.login.view.LoginScreenView;


/**
 * Created by aman on 15/10/16.
 */
public class LoginScreenPresenterImpl implements LoginScreenPresenter {

    private LoginScreenView loginView;
    private LoginProvider loginProvider;

    public LoginScreenPresenterImpl(LoginScreenView loginView, LoginProvider loginProvider) {
        this.loginView = loginView;
        this.loginProvider = loginProvider;
    }

    @Override
    public void requestLogin(String name, String password) {

        loginView.showLoading(true);
        Log.d("Resp", "1");
        loginProvider.requestLogin(name,password,new LoginCallback() {
            @Override
            public void onSuccess(LoginData loginData) {
                if (loginData.isSuccess()) {
                    loginView.showLoading(false);
                    loginView.onLoginVerified();
                } else {
                    loginView.showLoading(false);
                    loginView.showMessage(loginData.getMessage());

                }

            }

            public void onFailure(String error) {
                Log.d("Response", "false");
                loginView.showLoading(false);
                loginView.showMessage("Failed");

            }
        });


    }
}

