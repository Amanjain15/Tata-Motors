package com.executives.motors.add_customer.presenter;

/**
 * Created by aman on 29/1/17.
 */

public interface AddCustomerPresenter {

    void requestAddCustomer(String access_token);
    void responseAddCustomer( String access_token,int dsm_id,
                              String customer_name,
                              String address,
                              String email,
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
