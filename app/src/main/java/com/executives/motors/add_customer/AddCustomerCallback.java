package com.executives.motors.add_customer;

import com.executives.motors.add_customer.model.data.AddCustomerData;

/**
 * Created by aman on 27/1/17.
 */

public interface AddCustomerCallback {

        void onSuccess(AddCustomerData addCustomerData);
        void onFailure(String error);
}
