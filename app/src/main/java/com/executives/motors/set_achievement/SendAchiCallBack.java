package com.executives.motors.set_achievement;

import com.executives.motors.set_achievement.model.data.SendAchiData;

/**
 * Created by aman on 11/4/17.
 */

public interface SendAchiCallBack {

    void onSuccess(SendAchiData sendAchiData);
    void onFailure();
}
