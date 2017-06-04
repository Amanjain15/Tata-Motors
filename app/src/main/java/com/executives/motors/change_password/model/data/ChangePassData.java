package com.executives.motors.change_password.model.data;

/**
 * Created by aman on 5/3/17.
 */
public class ChangePassData {
    private  boolean success;
    private  String message;
    public ChangePassData(boolean success, String message) {

        this.success = success;
        this.message = message;
    }
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


}
