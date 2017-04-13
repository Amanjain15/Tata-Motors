package com.tata.motors.employee.model;

import com.tata.motors.employee.EmployeeCallBack;

/**
 * Created by aman on 24/1/17.
 */
public interface EmployeeProvider {
    void requestEmployee(String token,int choose_id,String user_c_type,EmployeeCallBack employeeCallBack);
}
