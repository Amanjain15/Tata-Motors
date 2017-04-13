package com.tata.motors.report_dsm;

import com.tata.motors.report_dsm.model.data.Report_dsmData;
import com.tata.motors.report_tsm.model.data.ReportTsmData;

/**
 * Created by aman on 12/4/17.
 */

public interface Report_dsmCallBack {

    void onSuccess(Report_dsmData report_dsmData);
    void onFailure();



}
