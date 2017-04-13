package com.tata.motors.set_achievement.model.data;

import java.util.List;

/**
 * Created by aman on 9/4/17.
 */

public class SetAchiData {
  private boolean success;
    private String message;
    List<EmployeeList>employeeLists;

    public SetAchiData(boolean success, String message, List<EmployeeList> employeeLists) {
        this.success = success;
        this.message = message;
        this.employeeLists = employeeLists;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }


    public List<EmployeeList> getEmployeeLists() {
        return employeeLists;
    }
}
