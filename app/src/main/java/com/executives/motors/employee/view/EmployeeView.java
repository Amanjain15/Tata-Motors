package com.executives.motors.employee.view;

import com.executives.motors.employee.model.data.EmployeeListDetails;

import java.util.List;

/**
 * Created by aman on 24/1/17.
 */
public interface EmployeeView {
    void showProgressbar(boolean show);
    void showMessage(String message);
    void dataReceived(List<EmployeeListDetails> employeeListDetailsList);
    void safe(int id);
}
