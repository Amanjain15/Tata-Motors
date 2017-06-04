package com.executives.motors.report_tsm.model.data;

import java.util.List;

/**
 * Created by aman on 8/3/17.
 */
public class ReportTsmData {
    private boolean success;
   private  String message;
    List<ReportTsmDetails> reportTsmDetailses;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ReportTsmDetails> getReportTsmDetailses() {
        return reportTsmDetailses;
    }

    public void setReportTsmDetailses(List<ReportTsmDetails> reportTsmDetailses) {
        this.reportTsmDetailses = reportTsmDetailses;
    }

    public ReportTsmData(boolean success, String message, List<ReportTsmDetails> reportTsmDetailses) {

        this.success = success;
        this.message = message;
        this.reportTsmDetailses = reportTsmDetailses;
    }
}
