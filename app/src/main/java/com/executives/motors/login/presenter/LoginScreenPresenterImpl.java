package com.executives.motors.login.presenter;

import android.util.Log;

import com.executives.motors.login.LoginCallback;
import com.executives.motors.login.models.LoginProvider;
import com.executives.motors.login.models.data.LoginData;
import com.executives.motors.login.view.LoginScreenView;


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
        Log.d("login","presenter");
        loginProvider.requestLogin(name,password,new LoginCallback() {
            @Override
            public void onSuccess(LoginData loginData) {
                if (loginData.isSuccess()) {
                    loginView.showLoading(false);
                    loginView.showMessage(loginData.getMessage());
                    Log.d("login","presenter_success");
                    loginView.onLoginVerified(loginData);

                } else {
                    loginView.showLoading(false);
                    loginView.showMessage(loginData.getMessage());
                    loginView.enableSubmit();

                }

            }

            public void onFailure(String error) {
                Log.d("login", "presenter_failure");
                loginView.showLoading(false);
                loginView.showMessage("Failed");
                loginView.enableSubmit();

            }
        });


    }
}

