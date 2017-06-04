package com.executives.motors.targets.model.data;

/**
 * Created by aman on 12/3/17.
 */

public class TargetData {

    private boolean success;
    private String message;
    private String targetDaily;
    private String targetMonthly;
    private String followup_today;

    public TargetData(boolean success, String message, String targetDaily, String targetMonthly, String followup_today) {
        this.success = success;
        this.message = message;
        this.targetDaily = targetDaily;
        this.targetMonthly = targetMonthly;
        this.followup_today = followup_today;
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

    public String getFollowup_today() {
        return followup_today;
    }
}
