package com.executives.motors.employee.model;

import com.executives.motors.employee.EmployeeCallBack;
import com.executives.motors.employee.SendStatusCallBack;

/**
 * Created by aman on 24/1/17.
 */
public interface EmployeeProvider {
    void requestEmployee(String token,int choose_id,String user_c_type,
                         String to_date,String from_date,int choice,
                         EmployeeCallBack employeeCallBack);
    void sendStatus(String access_token, int id, SendStatusCallBack sendStatusCallBack);
}
