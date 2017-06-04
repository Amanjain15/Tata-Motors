package com.executives.motors.view_customer.view;

import com.executives.motors.view_customer.model.data.ViewCustomerData;

/**
 * Created by aman on 11/4/17.
 */

public interface ViewCustomer {

    void showProgressBar(boolean show);
    void showError(String error);
    void setData(ViewCustomerData viewCustomerData);

}
