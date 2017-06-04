package com.executives.motors.add_customer.model;

import com.executives.motors.add_customer.AddCustomerCallback;

/**
 * Created by aman on 27/1/17.
 */

public interface AddCustomerProvider {

    void requestAddCustomer(String access_token,
                            AddCustomerCallback addCustomerCallback);
}
