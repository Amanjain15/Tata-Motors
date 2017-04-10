package com.tata.motors.add_customer.model;

import com.tata.motors.add_customer.CustomerAddedCallBack;

/**
 * Created by aman on 27/1/17.
 */

public interface CustomerAddedProvider {

    void responseAddCustomer(int dsm_id,
                             String customer_name,
                             String application_name,
                             String contact_no,
                             String district_name,
                             String town_name,
                             String tehsil,
                             String json,
                             String financier_name,
                             String follow_up,
                             int status,String location, CustomerAddedCallBack customerAddedCallBack);

}
