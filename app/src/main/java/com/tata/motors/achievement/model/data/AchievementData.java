package com.tata.motors.achievement.model.data;

import java.util.List;

/**
 * Created by aman on 9/4/17.
 */

public class AchievementData {
    boolean success;
    String message;
    List<AchievementDataDetails>achievementDataDetailses;

    public AchievementData(boolean success, String message, List<AchievementDataDetails> achievementDataDetailses) {
        this.success = success;
        this.message = message;
        this.achievementDataDetailses = achievementDataDetailses;
    }


    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<AchievementDataDetails> getAchievementDataDetailses() {
        return achievementDataDetailses;
    }
}
