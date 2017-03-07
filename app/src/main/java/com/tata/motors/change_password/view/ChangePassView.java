package com.tata.motors.change_password.view;

import com.tata.motors.change_password.model.data.ChangePassData;

/**
 * Created by aman on 5/3/17.
 */
public interface ChangePassView {

    void showLoading(boolean show);
    void showMessage(String message);
     void onVerified();
}
