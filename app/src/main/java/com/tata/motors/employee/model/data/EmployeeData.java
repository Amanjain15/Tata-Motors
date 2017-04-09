package com.tata.motors.employee.model.data;

import java.util.List;

/**
 * Created by aman on 24/1/17.
 */
public class EmployeeData {
    private boolean success;
    private String message;
    private List<EmployeeListDetails> employeeListDetails;//user_list

    public EmployeeData(boolean success, String message, List<EmployeeListDetails> employeeListDetails) {
        this.success = success;
        this.message = message;
        this.employeeListDetails = employeeListDetails;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<EmployeeListDetails> getEmployeeListDetails() {
        return employeeListDetails;
    }
}
