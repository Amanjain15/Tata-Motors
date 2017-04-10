package com.tata.motors.report_tsm.view;

import com.tata.motors.report_tsm.model.data.ReportTsmDetails;

import java.util.List;

/**
 * Created by aman on 8/3/17.
 */
public interface ReportTsmView {
    void showLoading(boolean show);
    void message(String message);
    void onVerified(List<ReportTsmDetails> reportTsmDetails);
    void onSelect();
}
