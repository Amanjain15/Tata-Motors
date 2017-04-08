package com.tata.motors.report_tsm;

import com.tata.motors.report_tsm.model.data.ReportTsmData;

/**
 * Created by aman on 8/3/17.
 */
public interface ReportTsmCallBack {

    void onSuccess(ReportTsmData reportTsmData);
    void onFailure();

}
