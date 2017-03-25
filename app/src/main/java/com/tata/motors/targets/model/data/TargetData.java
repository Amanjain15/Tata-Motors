package com.tata.motors.targets.model.data;

/**
 * Created by aman on 12/3/17.
 */

public class TargetData {

    private boolean success;
    private String message;
    private String targetDaily;
    private String targetMonthly;

    public TargetData(boolean success, String message, String targetDaily, String targetMonthly) {
        this.success = success;
        this.message = message;
        this.targetDaily = targetDaily;
        this.targetMonthly = targetMonthly;
    }


    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getTargetDaily() {
        return targetDaily;
    }

    public String getTargetMonthly() {
        return targetMonthly;
    }
}
