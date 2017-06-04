package com.executives.motors.add_user;

import com.executives.motors.add_user.model.data.AddUserData;

/**
 * Created by aman on 23/1/17.
 */

public interface AddUserCallBack {

    void onSuccess(AddUserData addUserData);
    void onFailure();
}
