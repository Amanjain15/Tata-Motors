package com.tata.motors.change_password;

import com.tata.motors.change_password.model.data.ChangePassData;

/**
 * Created by aman on 5/3/17.
 */
public interface ChangePassCallBack {
    void onSuccess(ChangePassData changePassData);
    void onFailure();
}
