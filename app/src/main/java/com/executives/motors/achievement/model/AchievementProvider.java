package com.executives.motors.achievement.model;

import com.executives.motors.achievement.AchievementCallBack;

/**
 * Created by aman on 9/4/17.
 */

public interface AchievementProvider {

    void requestAchievement(String access_token, AchievementCallBack achievementCallBack);
}
