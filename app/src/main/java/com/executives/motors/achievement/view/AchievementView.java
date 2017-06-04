package com.executives.motors.achievement.view;

import com.executives.motors.achievement.model.data.AchievementData;

/**
 * Created by aman on 9/4/17.
 */

public interface AchievementView {

    void showLoading(boolean show);
    void showMessage(String message);
    void onVerified(AchievementData achievementData);








}
