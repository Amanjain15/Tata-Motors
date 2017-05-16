package com.tata.motors.report_dsm.model.data;

/**
 * Created by aman on 12/4/17.
 */

public class StatusData {
    private String message;
    private boolean success;

    public StatusData(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
