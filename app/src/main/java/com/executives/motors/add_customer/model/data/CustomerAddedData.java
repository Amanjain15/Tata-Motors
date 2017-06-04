package com.executives.motors.add_customer.model.data;



/**
 * Created by aman on 27/1/17.
 */

public class CustomerAddedData {

    private boolean success;
    private String message;

    public CustomerAddedData(boolean success, String message) {
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
