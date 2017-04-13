package com.tata.motors.report_dsm.model.data;

import java.util.List;

/**
 * Created by aman on 12/4/17.
 */

public class Report_dsmData {

    private String message;
    private boolean success;
    List<ReportDaily> reportDailyList;
    List<ReportMonthly> reportMonthlyList;

    public Report_dsmData(String message, boolean success, List<ReportDaily> reportDailyList, List<ReportMonthly> reportMonthlyList) {
        this.message = message;
        this.success = success;
        this.reportDailyList = reportDailyList;
        this.reportMonthlyList = reportMonthlyList;

    }


    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<ReportDaily> getReportDailyList() {
        return reportDailyList;
    }

    public List<ReportMonthly> getReportMonthlyList() {
        return reportMonthlyList;
    }
}
