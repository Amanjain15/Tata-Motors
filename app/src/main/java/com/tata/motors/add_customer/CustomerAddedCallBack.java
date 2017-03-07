package com.tata.motors.add_customer;

import com.tata.motors.add_customer.model.data.CustomerAddedData;

/**
 * Created by aman on 8/2/17.
 */

public interface CustomerAddedCallBack {

    void onSuccess(CustomerAddedData customerAddedData);
    void onFailure(String error);
}
