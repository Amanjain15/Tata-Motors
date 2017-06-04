package com.executives.motors.set_achievement.model;

import com.executives.motors.set_achievement.SendAchiCallBack;
import com.executives.motors.set_achievement.SetAchiCallBack;

/**
 * Created by aman on 9/4/17.
 */

public interface SetAchiProvider {
    void requestSpinner(String access_token, SetAchiCallBack setAchiCallBack);
    void sendAchi(String access_token, int id, String achievement, SendAchiCallBack sendAchiCallBack);




}
