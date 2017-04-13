package com.tata.motors.add_customer.model;


import com.tata.motors.add_customer.CustomerAddedCallBack;
import com.tata.motors.add_customer.EditCustomerCallBack;

/**
 * Created by aman on 12/4/17.
 */

public interface EditCustomerProvider {

    void requestEditCustomer(String access_token, int choose_id, EditCustomerCallBack editCustomerCallBack);
    void responseEditCustomer(String access_token, int user_id,
                              int choose_id,
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
                              int status, String location, CustomerAddedCallBack customerAddedCallBack);

}
