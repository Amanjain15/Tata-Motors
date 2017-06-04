package com.executives.motors.set_achievement.presenter;

import com.executives.motors.set_achievement.SendAchiCallBack;
import com.executives.motors.set_achievement.SetAchiCallBack;
import com.executives.motors.set_achievement.model.SetAchiProvider;
import com.executives.motors.set_achievement.model.data.SendAchiData;
import com.executives.motors.set_achievement.model.data.SetAchiData;
import com.executives.motors.set_achievement.view.SetAchiView;

/**
 * Created by aman on 9/4/17.
 */

public class SetAchiPresenterImpl implements SetAchiPresenter{
    private SetAchiProvider setAchiProvider;
    private SetAchiView setAchiView;

    public SetAchiPresenterImpl(SetAchiProvider setAchiProvider, SetAchiView setAchiView) {
        this.setAchiProvider = setAchiProvider;
        this.setAchiView = setAchiView;
    }

    @Override
    public void requestSpinner(String access_token) {
        setAchiView.showLoading(true);
        setAchiProvider.requestSpinner(access_token, new SetAchiCallBack() {
            @Override
            public void onSuccess(SetAchiData setAchiData) {
                if(setAchiData.isSuccess()) {
                    setAchiView.showLoading(false);
                    setAchiView.onVerified(setAchiData);
                }
                else
                {
                    setAchiView.showLoading(false);
                    setAchiView.showMessage(setAchiData.getMessage());

                }
            }

            @Override
            public void onFailure() {

                setAchiView.showLoading(false);
                setAchiView.showMessage("UNABLE TO CONNECT");

            }
        });
    }


    @Override
    public void sendAchi(String access_token, int id, String achievement) {
        setAchiView.showProgreebar(true);
        setAchiProvider.sendAchi(access_token, id, achievement, new SendAchiCallBack() {
            @Override
            public void onSuccess(SendAchiData sendAchiData) {
                if(sendAchiData.isSuccess())
                { setAchiView.showProgreebar(false);
                    setAchiView.onSend();

                }
                else
                {
                    setAchiView.showProgreebar(false);
                    setAchiView.showMessage(sendAchiData.getMessage());
                }
            }

            @Override
            public void onFailure() {
                setAchiView.showProgreebar(false);
                setAchiView.showMessage("UNABLE TO CONNECT");
            }
        });
    }
}
