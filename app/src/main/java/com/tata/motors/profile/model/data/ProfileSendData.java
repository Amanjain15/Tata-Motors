package com.tata.motors.profile.model.data;

/**
 * Created by aman on 26/1/17.
 */
public class ProfileSendData {
    private boolean success;
    private String message;

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

    public ProfileSendData(boolean success, String message) {

        this.success = success;
        this.message = message;
    }
}
