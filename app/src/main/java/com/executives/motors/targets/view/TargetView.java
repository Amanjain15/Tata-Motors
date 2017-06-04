package com.executives.motors.targets.view;

import com.executives.motors.targets.model.data.TargetData;

/**
 * Created by aman on 6/3/17.
 */

public interface TargetView {

    void showError(String error);
    void showProgressBar(boolean show);
    void setData(TargetData targetData);
}
