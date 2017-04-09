package com.tata.motors.login.models;

import android.os.Handler;
import android.util.Log;

import com.tata.motors.login.LoginCallback;
import com.tata.motors.login.models.data.LoginData;

/**
 * Created by aman on 4/3/17.
 */

public class MockLoginProvider implements LoginProvider{


    @Override
    public void requestLogin(String name, String password, final LoginCallback loginUsCallback) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                loginUsCallback.onSuccess(getMockLoginData());
                //Log.d("Mock","1");


            }
        },500);

    }

    private LoginData getMockLoginData(){

        LoginData loginData = new LoginData("Success",true,"A12A200","0",1234,false);
        return loginData;

    }


}
