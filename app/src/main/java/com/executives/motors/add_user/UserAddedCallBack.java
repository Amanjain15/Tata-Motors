package com.executives.motors.add_user;

import com.executives.motors.add_user.model.data.UserAddedData;

/**
 * Created by aman on 24/1/17.
 */

public interface UserAddedCallBack {

    void onSuccess(UserAddedData userAddedData);
    void onFailure(String error);


}
