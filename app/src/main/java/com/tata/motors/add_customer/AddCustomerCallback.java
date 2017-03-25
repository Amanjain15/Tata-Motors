package com.tata.motors.add_customer;

import com.tata.motors.add_customer.model.data.AddCustomerData;

/**
 * Created by aman on 27/1/17.
 */

public interface AddCustomerCallback {

    void onSuccess(AddCustomerData addCustomerData);
    void onFailure(String error);
}
