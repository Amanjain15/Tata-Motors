package com.tata.motors.add_user.model.data;

/**
 * Created by aman on 24/1/17.
 */

public class UserAddedData {

    private boolean success;
    private String message;
    private String password;

    public UserAddedData(boolean success, String message, String password) {
        this.success = success;
        this.message = message;
        this.password = password;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getPassword() {
        return password;
    }
}
