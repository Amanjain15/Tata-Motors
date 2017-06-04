package com.executives.motors.targets;

import com.executives.motors.targets.model.data.TargetDataTsm;

/**
 * Created by aman on 13/3/17.
 */

public interface SetTargetCallBack {

    void onSuccess(TargetDataTsm targetDataTsm);
    void onFailure(String error);
}
