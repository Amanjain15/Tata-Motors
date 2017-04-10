package com.tata.motors.achievement.presenter;

import com.tata.motors.achievement.AchievementCallBack;
import com.tata.motors.achievement.api.AchievementApi;
import com.tata.motors.achievement.model.AchievementProvider;
import com.tata.motors.achievement.model.data.AchievementData;
import com.tata.motors.achievement.view.AchievementView;

/**
 * Created by aman on 9/4/17.
 */

public class AchievementPresenterImpl implements AchievementPresenter {
    private AchievementView achievementView;
    private AchievementProvider achievementProvider;


    public AchievementPresenterImpl(AchievementView achievementView, AchievementProvider achievementProvider) {
        this.achievementView = achievementView;
        this.achievementProvider = achievementProvider;
    }

    @Override
    public void requestAchievement(String access_token) {
        achievementView.showLoading(true);
        achievementProvider.requestAchievement(access_token, new AchievementCallBack() {
            @Override
            public void onSuccess(AchievementData achievementData) {
                if (achievementData.isSuccess()) {
                    achievementView.showLoading(false);
                    achievementView.onVerified(achievementData);
                } else {
                    achievementView.showLoading(false);
                    achievementView.showMessage(achievementData.getMessage());
                }
            }
            @Override
            public void onFailure() {
                achievementView.showLoading(false);
                achievementView.showMessage("UNABLE TO CONNECT");

            }
        });
    }


}
