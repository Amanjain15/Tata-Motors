package com.tata.motors.change_password.presenter;

import com.tata.motors.change_password.ChangePassCallBack;

import com.tata.motors.change_password.model.ChangePassProvider;
import com.tata.motors.change_password.model.data.ChangePassData;
import com.tata.motors.change_password.view.ChangePassView;

/**
 * Created by aman on 5/3/17.
 */
public class ChangePassPresenterImpl implements ChangePassPresenter {
    private ChangePassProvider changePassProvider;
    private ChangePassView changePassView;

    public ChangePassPresenterImpl(ChangePassProvider changePassProvider, ChangePassView changePassView) {
        this.changePassProvider = changePassProvider;
        this.changePassView = changePassView;
    }

    @Override
    public void requestChangePass(String token, String oldPassword, String newPassword) {

        changePassView.showLoading(true);
        changePassProvider.requestChangePass(token, oldPassword, newPassword, new ChangePassCallBack() {
            @Override
            public void onSuccess(ChangePassData changePassData) {
                if (changePassData.isSuccess()) {
                    changePassView.showLoading(false);
                    changePassView.onVerified();
                } else {
                    changePassView.showLoading(false);
                    changePassView.showMessage(changePassData.getMessage());
                }


            }

            @Override
            public void onFailure() {
                changePassView.showLoading(false);
                changePassView.showMessage("Unable to connect");

            }

        });



    }
}
