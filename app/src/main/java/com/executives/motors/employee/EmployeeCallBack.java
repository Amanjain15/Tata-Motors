package com.executives.motors.employee;

import com.executives.motors.employee.model.data.EmployeeData;

/**
 * Created by aman on 24/1/17.
 */
public interface EmployeeCallBack {

    void onSuccess(EmployeeData employeeData);
    void onFailure();

}
