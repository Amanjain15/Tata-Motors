package com.executives.motors.set_achievement.presenter;

/**
 * Created by aman on 9/4/17.
 */

public interface SetAchiPresenter {


    void requestSpinner(String access_token);
    void sendAchi(String access_token,int id,String achievement);
}
