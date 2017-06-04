package com.executives.motors.achievement;

import com.executives.motors.achievement.model.data.AchievementData;

/**
 * Created by aman on 9/4/17.
 */

public interface AchievementCallBack {
    void onSuccess(AchievementData achievementData);
    void onFailure();
}
