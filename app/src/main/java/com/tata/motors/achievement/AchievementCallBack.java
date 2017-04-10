package com.tata.motors.achievement;

import com.tata.motors.achievement.model.data.AchievementData;

/**
 * Created by aman on 9/4/17.
 */

public interface AchievementCallBack {
    void onSuccess(AchievementData achievementData);
    void onFailure();
}
