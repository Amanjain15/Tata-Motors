package com.executives.motors.follow_up.model;

import com.executives.motors.follow_up.FollowUpCallBack;

/**
 * Created by aman on 11/4/17.
 */

public interface FollowUpProvider {
    void requestFollowUp(String access_token, int customer_id, FollowUpCallBack followUpCallBack);

}
