package com.executives.motors.report_dsm;

import com.executives.motors.report_dsm.model.data.StatusData;

/**
 * Created by aman on 12/4/17.
 */

public interface SendStatusCallBack {
    void onSuccess(StatusData statusData);
    void onFailure();
}
