package com.executives.motors.targets.view;

import com.executives.motors.targets.model.data.TargetDataTsm;
import com.executives.motors.targets.model.data.TargetListDetails;

/**
 * Created by aman on 13/3/17.
 */

public interface SetTargetView {

    void showError(String error);
    void showProgressBar(boolean show);
    void setData(TargetDataTsm targetDataTsm);
    void dialog(final TargetListDetails targetListDetails);

}
