package com.tata.motors.follow_up;

import com.tata.motors.follow_up.model.data.FollowUpData;

/**
 * Created by aman on 11/4/17.
 */

public interface FollowUpCallBack {

    void onSuccess(FollowUpData followUpData);
    void Failure(String error);
}
