package com.tata.motors.targets.model.data;

/**
 * Created by aman on 4/4/17.
 */

public class TargetResponseData {
    private boolean success;
    private String message;

    public TargetResponseData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
