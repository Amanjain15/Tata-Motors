package com.tata.motors.employee;


import com.tata.motors.employee.model.data.StatusData;

/**
 * Created by aman on 12/4/17.
 */

public interface SendStatusCallBack {
    void onSuccess(StatusData statusData);
    void onFailure(String error);
}
