package com.tata.motors.set_achievement.model.data;

/**
 * Created by aman on 11/4/17.
 */

public class SendAchiData {


    private boolean success;
    private String message;

    public SendAchiData(boolean success, String message) {
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
