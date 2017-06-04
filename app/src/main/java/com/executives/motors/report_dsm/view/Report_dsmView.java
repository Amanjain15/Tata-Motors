package com.executives.motors.report_dsm.view;

import com.executives.motors.report_dsm.model.data.Report_dsmData;

/**
 * Created by aman on 12/4/17.
 */

public interface Report_dsmView {

    void showLoading(boolean show);
    void message(String message);
    void onVerified(Report_dsmData report_dsmData);
    void statusCal(int id);






}
