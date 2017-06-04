package com.executives.motors.employee.presenter;

/**
 * Created by aman on 24/1/17.
 */
public interface EmployeePresenter {
    void requestEmployee(String token,int choose_id,String user_c_type,String to_date,String from_date,int choice);
    void sendStatus(String access_token,int id);

}