package com.tata.motors.add_customer.presenter;

/**
 * Created by aman on 29/1/17.
 */

public interface AddCustomerPresenter {

    void requestAddCustomer(String access_token);
    void responseAddCustomer( int dsm_id,
                              String customer_name,
                              String application_name,
                              String contact_no,
                              String district_name,
                              String town_name,
                              String tehsil,
                              String json,
                              String financier_name,
                              String follow_up,
                              int status,
                              String location);
}
