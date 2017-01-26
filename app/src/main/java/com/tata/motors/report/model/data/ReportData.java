package com.tata.motors.report.model.data;

import java.util.List;

/**
 * Created by iket on 23/1/17.
 */
public class ReportData {

    private List<Monthly> monthly;
    private List<Daily> daily;
    private boolean success;
    private String message;

    public ReportData(List<Monthly> monthly, List<Daily> daily, boolean success, String message) {
        this.monthly = monthly;
        this.daily = daily;
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<Monthly> getMonthly() {
        return monthly;
    }

    public List<Daily> getDaily() {
        return daily;
    }
}
