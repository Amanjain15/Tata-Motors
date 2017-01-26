package com.tata.motors.report.view;

import com.tata.motors.report.model.data.ReportData;


public interface ReportView {
    void showMessage(String message);

    void showProgressbar(boolean show);

    void onDataReceived(ReportData reportDatas,int i);

}
