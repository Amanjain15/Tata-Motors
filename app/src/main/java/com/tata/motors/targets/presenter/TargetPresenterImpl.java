package com.tata.motors.targets.presenter;

import android.util.Log;

import com.tata.motors.targets.ResponseTargetCallBack;
import com.tata.motors.targets.SetTargetCallBack;
import com.tata.motors.targets.TargetCallBack;
import com.tata.motors.targets.model.TargetProvider;
import com.tata.motors.targets.model.data.TargetData;
import com.tata.motors.targets.model.data.TargetDataTsm;
import com.tata.motors.targets.model.data.TargetResponseData;
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
    public void requestTarget(String user_type,String user_id, String username) {
        targetView.showProgressBar(true);
        targetProvider.requestTarget(user_type,user_id, username, new TargetCallBack() {
            @Override
            public void onSuccess(TargetData targetData) {
                if(targetData.isSuccess()){
                    targetView.setData(targetData);
                    Log.d("targetPresenter",targetData.getTargetDaily()+" "+targetData.getTargetMonthly());
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
        setTargetView.showProgressBar(true);
        targetProvider.requestSetTarget(user_id, username, new SetTargetCallBack() {
            @Override
            public void onSuccess(TargetDataTsm targetDataTsm) {
                if(targetDataTsm.isSuccess())
                {
                    setTargetView.showProgressBar(false);
                    setTargetView.setData(targetDataTsm);
                    setTargetView.showError(targetDataTsm.getMessage());
                    Log.d("setTarget","presenter_success");
                }
                else {
                    setTargetView.showProgressBar(false);
                    setTargetView.showError(targetDataTsm.getMessage());
                }
            }

            @Override
            public void onFailure(String error) {
                Log.d("setTarget","presenter_failed");
                setTargetView.showProgressBar(false);
                setTargetView.showError("Something Went Wrong.\nTry Again Sometime Later");
            }
        });

    }

    @Override
    public void responseSetTarget(String access_token, String user_id, String username, String monthly, String daily) {
        targetProvider.responseSetTarget(access_token, user_id, username, monthly, daily, new ResponseTargetCallBack() {
            @Override
            public void onSuccess(TargetResponseData targetResponseData) {
                if(targetResponseData.isSuccess())
                {
                    setTargetView.showError(targetResponseData.getMessage());
                }
                else {
                    setTargetView.showError(targetResponseData.getMessage());

                }
            }

            @Override
            public void onFailure(String error) {
                setTargetView.showError("Something Went Wrong.\nTry Again Sometime Later");
            }
        });
    }
}
