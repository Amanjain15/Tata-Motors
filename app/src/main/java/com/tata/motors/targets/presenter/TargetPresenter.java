package com.tata.motors.targets.presenter;


/**
 * Created by aman on 6/3/17.
 */

public interface TargetPresenter {

    void requestTarget(String user_type,String user_id, String username);
    void requestSetTarget(String user_id, String username);
    void responseSetTarget(String access_token, String user_id, String username, String monthly,
                           String daily);
}
