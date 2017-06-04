package com.executives.motors.report_dsm;

import com.executives.motors.report_dsm.model.data.Report_dsmData;

/**
 * Created by aman on 12/4/17.
 */

public interface Report_dsmCallBack {

    void onSuccess(Report_dsmData report_dsmData);
    void onFailure();



}
