package com.tata.motors.employee.model;

import com.tata.motors.employee.EmployeeCallBack;
import com.tata.motors.employee.SendStatusCallBack;


import retrofit2.http.Query;

/**
 * Created by aman on 24/1/17.
 */
public interface EmployeeProvider {
    void requestEmployee(String token,int choose_id,String user_c_type,
                         String to_date,String from_date,int choice,
                         EmployeeCallBack employeeCallBack);
    void sendStatus(String access_token, int id, SendStatusCallBack sendStatusCallBack);
}
