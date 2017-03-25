package com.tata.motors.targets.view;

import com.tata.motors.targets.model.data.TargetData;
import com.tata.motors.targets.model.data.TargetDataTsm;

/**
 * Created by aman on 13/3/17.
 */

public interface SetTargetView {

    void showError(String error);
    void showProgressBar(boolean show);
    void setData(TargetDataTsm targetDataTsm);

}
