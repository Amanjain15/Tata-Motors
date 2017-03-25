package com.tata.motors.targets.presenter;

import com.tata.motors.targets.TargetCallBack;
import com.tata.motors.targets.model.TargetProvider;
import com.tata.motors.targets.model.data.TargetData;
import com.tata.motors.targets.view.SetTargetView;
import com.tata.motors.targets.view.TargetView;


/**
 * Created by aman on 6/3/17.
 */

public class TargetPresenterImpl implements TargetPresenter {

    private TargetView targetView;
    private TargetProvider targetProvider;
    private SetTargetView setTargetView;

    public TargetPresenterImpl(TargetView targetView, TargetProvider targetProvider) {
        this.targetView = targetView;
        this.targetProvider = targetProvider;
    }

    public TargetPresenterImpl(TargetProvider targetProvider, SetTargetView setTargetView) {
        this.targetProvider = targetProvider;
        this.setTargetView = setTargetView;
    }

    @Override
    public void requestTarget(String user_id, String username) {
        targetView.showProgressBar(true);
        targetProvider.requestTarget(user_id, username, new TargetCallBack() {
            @Override
            public void onSuccess(TargetData targetData) {
                if(targetData.isSuccess()){
                    targetView.setData(targetData);
                    targetView.showProgressBar(false);
                }
                else
                {
                    targetView.showProgressBar(false);
                    targetView.showError(targetData.getMessage());
                }
            }

            @Override
            public void onFailure(String error) {
                targetView.showProgressBar(false);
                targetView.showError("Something Went Wrong");
            }
        });
    }

    @Override
    public void requestSetTarget(String user_id, String username) {

    }
}
