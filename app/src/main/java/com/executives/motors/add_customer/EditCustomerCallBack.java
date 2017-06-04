package com.executives.motors.add_customer;


import com.executives.motors.add_customer.model.data.EditCustomerData;

/**
 * Created by aman on 12/4/17.
 */

public interface EditCustomerCallBack {
    void onSuccess(EditCustomerData editCustomerData);
    void onFailure(String error);
}
