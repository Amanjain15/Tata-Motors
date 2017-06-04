package com.executives.motors.follow_up.presenter;

import com.executives.motors.follow_up.FollowUpCallBack;
import com.executives.motors.follow_up.model.FollowUpProvider;
import com.executives.motors.follow_up.model.data.FollowUpData;
import com.executives.motors.follow_up.view.FollowUpView;

/**
 * Created by aman on 11/4/17.
 */

public class FollowUpPresenterImpl implements FollowUpPresenter {

    private FollowUpView followUpView;
    private FollowUpProvider followUpProvider;

    public FollowUpPresenterImpl(FollowUpView followUpView, FollowUpProvider followUpProvider) {
        this.followUpView = followUpView;
        this.followUpProvider = followUpProvider;
    }

    @Override
    public void requestFollow(String access_token, int customer_id) {
        followUpView.showProgressBar(true);
        followUpProvider.requestFollowUp(access_token, customer_id, new FollowUpCallBack() {
            @Override
            public void onSuccess(FollowUpData followUpData) {
                if(followUpData.isSuccess())
                {
                    followUpView.showProgressBar(false);
                    followUpView.showError(followUpData.getMessage());
                    followUpView.setDataValues(followUpData.getFollow_up_details());
                }
                else
                {
                    followUpView.showProgressBar(false);
                    followUpView.showError(followUpData.getMessage());
                }
            }

            @Override
            public void Failure(String error) {
                followUpView.showProgressBar(false);
                followUpView.showError(error);
            }
        });
    }
}
