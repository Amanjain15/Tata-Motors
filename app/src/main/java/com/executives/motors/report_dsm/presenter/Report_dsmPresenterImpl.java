package com.executives.motors.report_dsm.presenter;

import com.executives.motors.report_dsm.Report_dsmCallBack;
import com.executives.motors.report_dsm.SendStatusCallBack;
import com.executives.motors.report_dsm.model.Report_dsmProvider;
import com.executives.motors.report_dsm.model.data.Report_dsmData;
import com.executives.motors.report_dsm.model.data.StatusData;
import com.executives.motors.report_dsm.view.Report_dsmView;

/**
 * Created by aman on 12/4/17.
 */

public class Report_dsmPresenterImpl implements Report_dsmPresenter {

    private Report_dsmProvider report_dsmProvider;
    private Report_dsmView report_dsmView;

    public Report_dsmPresenterImpl(Report_dsmProvider report_dsmProvider, Report_dsmView report_dsmView) {
        this.report_dsmProvider = report_dsmProvider;
        this.report_dsmView = report_dsmView;
    }

    @Override
    public void requestDsm(String access_token, int user_id,int type) {
        report_dsmView.showLoading(true);
        report_dsmProvider.requestDsm(access_token, user_id,type, new Report_dsmCallBack() {
            @Override
            public void onSuccess(Report_dsmData report_dsmData) {
                if (report_dsmData.isSuccess()) {
                    report_dsmView.showLoading(false);
                    report_dsmView.onVerified(report_dsmData);
                    report_dsmView.message(report_dsmData.getMessage());
                } else {
                          report_dsmView.showLoading(false);
                report_dsmView.message(report_dsmData.getMessage());
                }
            }
            @Override
            public void onFailure() {
report_dsmView.showLoading(false);
                report_dsmView.message("UNABLE TO CONNECT");
            }
        });
    }

    @Override
    public void sendStatus(String access_token, int id) {
        report_dsmProvider.sendStatus(access_token, id, new SendStatusCallBack() {
            @Override
            public void onSuccess(StatusData statusData) {
                if (statusData.isSuccess()) {
                    report_dsmView.message("SUCCESSFULLY DONE");
                } else {
                            report_dsmView.message(statusData.getMessage());
                }

            }
            @Override
            public void onFailure() {
                report_dsmView.message("UNABLE TO CONNECT");

            }
        });
    }
}
