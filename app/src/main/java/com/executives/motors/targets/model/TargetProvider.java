package com.executives.motors.targets.model;

import com.executives.motors.targets.ResponseTargetCallBack;
import com.executives.motors.targets.SetTargetCallBack;
import com.executives.motors.targets.TargetCallBack;

/**
 * Created by aman on 6/3/17.
 */

public interface TargetProvider {

    void requestTarget(String access_token,TargetCallBack targetCallBack);
    void requestSetTarget(int user_id, String username, SetTargetCallBack setTargetCallBack);
    void responseSetTarget(String access_token, int user_id, String username, String monthly,
                           String daily, ResponseTargetCallBack responseTargetCallBack);
}
