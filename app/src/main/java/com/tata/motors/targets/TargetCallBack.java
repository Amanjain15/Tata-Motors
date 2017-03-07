package com.tata.motors.targets;

import com.tata.motors.targets.model.data.TargetData;

/**
 * Created by aman on 6/3/17.
 */

public interface TargetCallBack {

    void onSuccess(TargetData targetData);
    void onFailure(String error);

}