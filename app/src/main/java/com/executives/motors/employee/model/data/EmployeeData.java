package com.executives.motors.employee.model.data;

import java.util.List;

/**
 * Created by aman on 24/1/17.
 */
public class EmployeeData {
    private boolean success;
    private String message;
    private List<EmployeeListDetails> user_list;//user_list

    public EmployeeData(boolean success, String message, List<EmployeeListDetails> employeeListDetails) {
        this.success = success;
        this.message = message;
        this.user_list = employeeListDetails;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<EmployeeListDetails> getEmployeeListDetails() {
        return user_list;
    }
}
