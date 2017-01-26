package com.tata.motors.report.view;

import com.tata.motors.report.model.data.ReportData;

/**
 * Created by iket on 19/10/16.
 */
public interface OnReportReceived {
    void onFailure();

    void onSuccess(ReportData reportData);
}
