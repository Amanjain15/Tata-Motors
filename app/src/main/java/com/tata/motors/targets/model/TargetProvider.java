package com.tata.motors.targets.model;

import com.tata.motors.targets.SetTargetCallBack;
import com.tata.motors.targets.TargetCallBack;

/**
 * Created by aman on 6/3/17.
 */

public interface TargetProvider {

    void requestTarget(String user_id, String username, TargetCallBack targetCallBack);
    void requestSetTarget(String user_id, String username, SetTargetCallBack setTargetCallBack);
}
