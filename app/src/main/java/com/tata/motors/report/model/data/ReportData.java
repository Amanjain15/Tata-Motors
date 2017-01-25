package com.tata.motors.report.model.data;

import java.util.List;

/**
 * Created by iket on 23/1/17.
 */
public class ReportData {
    private boolean success;
    private String message;
    private List<Monthly> monthly;
    private List<Daily> daily;

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
