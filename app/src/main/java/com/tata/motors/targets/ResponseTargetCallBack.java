package com.tata.motors.targets;

import com.tata.motors.targets.model.data.TargetResponseData;

/**
 * Created by aman on 4/4/17.
 */

public interface ResponseTargetCallBack {

    void onSuccess(TargetResponseData targetResponseData);
    void onFailure(String error);
}
