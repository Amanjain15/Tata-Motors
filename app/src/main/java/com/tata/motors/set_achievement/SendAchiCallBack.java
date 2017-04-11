package com.tata.motors.set_achievement;

import com.tata.motors.set_achievement.model.data.SendAchiData;
import com.tata.motors.set_achievement.model.data.SetAchiData;

/**
 * Created by aman on 11/4/17.
 */

public interface SendAchiCallBack {

    void onSuccess(SendAchiData sendAchiData);
    void onFailure();
}
