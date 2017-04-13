package com.tata.motors.view_customer.model;

import com.tata.motors.view_customer.ViewCustomerCallBack;

/**
 * Created by aman on 11/4/17.
 */

public interface ViewCustomerProvider {

    void requestViewCustomer(String access_token, int choose_id, ViewCustomerCallBack viewCustomerCallBack);

}
