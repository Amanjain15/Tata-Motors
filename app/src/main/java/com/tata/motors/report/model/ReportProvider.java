package com.tata.motors.report.model;

import com.tata.motors.report.view.OnReportReceived;

/**
 * Created by iket on 19/10/16.
 */
public interface ReportProvider {
    void getReport(String access_token, OnReportReceived onReportReceived);

}
