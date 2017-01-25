package com.tata.motors.report.presenter;

import com.tata.motors.report.model.ReportProvider;
import com.tata.motors.report.model.data.ReportData;
import com.tata.motors.report.view.OnReportReceived;
import com.tata.motors.report.view.ReportView;

public class ReportPresenterImpl implements ReportPresenter {

    private ReportView reportView;
    private ReportProvider reportProvider;

    public ReportPresenterImpl(ReportView reportView, ReportProvider reportProvider) {
        this.reportView = reportView;
        this.reportProvider = reportProvider;
    }

    @Override
    public void getReport(String access_token) {

        reportView.showProgressbar(true);

        reportProvider.getReport(access_token, new OnReportReceived() {
            @Override
            public void onFailure() {
                reportView.showProgressbar(false);
                reportView.showMessage("Error..try again");
            }

            @Override
            public void onSuccess(ReportData reportData) {
                if (reportData.isSuccess()) {
                    reportView.showProgressbar(false);
                    reportView.onDataReceived(reportData);

                } else {
                    reportView.showProgressbar(false);
                    reportView.showMessage(reportData.getMessage());

                }
            }

        });
    }
}
