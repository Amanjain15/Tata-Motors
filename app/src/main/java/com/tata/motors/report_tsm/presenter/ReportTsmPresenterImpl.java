package com.tata.motors.report_tsm.presenter;


import com.tata.motors.report_tsm.ReportTsmCallBack;
import com.tata.motors.report_tsm.model.ReportTsmProvider;
import com.tata.motors.report_tsm.model.data.ReportTsmData;
import com.tata.motors.report_tsm.view.ReportTsmView;

/**
 * Created by aman on 8/3/17.
 */
public class ReportTsmPresenterImpl implements ReportTsmPresenter {

private ReportTsmProvider reportTsmProvider;
    private ReportTsmView reportTsmView;

    public ReportTsmPresenterImpl(ReportTsmProvider reportTsmProvider, ReportTsmView reportTsmView) {
        this.reportTsmProvider = reportTsmProvider;
        this.reportTsmView = reportTsmView;
    }

    @Override
    public void requestTsmReport(String token) {
        reportTsmProvider.requestTsmReport(token, new ReportTsmCallBack() {
            @Override
            public void onSuccess(ReportTsmData reportTsmData) {

                if (reportTsmData.isSuccess()) {
                    reportTsmView.showLoading(false);
                    reportTsmView.onVerified(reportTsmData.getReportTsmDetailses());
                } else {
                    reportTsmView.showLoading(false);
                    reportTsmView.message(reportTsmData.getMessage());
                }
            }

            @Override
            public void onFailure() {
                reportTsmView.showLoading(false);
                reportTsmView.message("unable to connect");
            }

            });
        }
    }
