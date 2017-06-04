package com.executives.motors.add_customer.presenter;

/**
 * Created by aman on 12/4/17.
 */

public interface EditCustomerPresenter {
    void requestEditCustomer(String access_token,int choose_id);
    void responseEditCustomer( String access_token,int dsm_id,int choose_id,
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
