package com.executives.motors.employee.model.data;

/**
 * Created by aman on 12/4/17.
 */

public class StatusData {
    private String message;
    private boolean success;
    private int id;

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getId() {
        return id;
    }

    public StatusData(String message, boolean success, int id) {

        this.message = message;
        this.success = success;
        this.id = id;
    }
}
