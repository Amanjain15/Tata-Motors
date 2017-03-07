package com.tata.motors.add_customer.model;

import com.tata.motors.add_customer.AddCustomerCallback;

/**
 * Created by aman on 27/1/17.
 */

public interface AddCustomerProvider {

    void requestAddCustomer(String access_token, String user_id, String user_type,
                            AddCustomerCallback addCustomerCallback);
}
