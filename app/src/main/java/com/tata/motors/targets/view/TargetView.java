package com.tata.motors.targets.view;

import com.tata.motors.targets.model.data.TargetData;
import com.tata.motors.targets.model.data.TargetDataTsm;

/**
 * Created by aman on 6/3/17.
 */

public interface TargetView {

    void showError(String error);
    void showProgressBar(boolean show);
    void setData(TargetData targetData);
}
