package com.tata.motors.employee;

import com.tata.motors.employee.model.data.EmployeeData;

/**
 * Created by aman on 24/1/17.
 */
public interface EmployeeCallBack {

    void onSuccess(EmployeeData employeeData);
    void onFailure(String error);

}
