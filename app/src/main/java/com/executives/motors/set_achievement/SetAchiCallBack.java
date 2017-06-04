package com.executives.motors.set_achievement;

import com.executives.motors.set_achievement.model.data.SetAchiData;

/**
 * Created by aman on 9/4/17.
 */

public interface SetAchiCallBack {



    void onSuccess(SetAchiData setAchiData);
    void onFailure();
}
