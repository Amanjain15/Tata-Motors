package com.executives.motors.view_customer;

import com.executives.motors.view_customer.model.data.ViewCustomerData;

/**
 * Created by aman on 11/4/17.
 */

public interface ViewCustomerCallBack {

    void onSuccess(ViewCustomerData viewCustomerData);
    void onFailure(String error);
}
