package com.tata.motors.add_customer.model;

import com.tata.motors.add_customer.CustomerAddedCallBack;

/**
 * Created by aman on 27/1/17.
 */

public interface CustomerAddedProvider {

    void responseAddCustomer(String dsm_id,
                             String dse_id,
                             String customer_name,
                             String application_id,
                             String contact_no,
                             String district_id,
                             String town_id,
                             String tehsil,
                             String model_id,
                             String quantity,
                             String vehicle_id,
                             String financier_id,
                             int follow_up,
                             String geo_tag, CustomerAddedCallBack customerAddedCallBack);

}
