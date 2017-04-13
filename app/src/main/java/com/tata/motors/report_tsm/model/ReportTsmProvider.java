package com.tata.motors.report_tsm.model;

import com.tata.motors.report_tsm.ReportTsmCallBack;

/**
 * Created by aman on 8/3/17.
 */
public interface ReportTsmProvider {

    void requestTsmReport(String token,ReportTsmCallBack reportTsmCallBack);

}
