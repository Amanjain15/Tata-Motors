package com.tata.motors.add_customer.model;

import com.tata.motors.add_customer.CustomerAddedCallBack;

/**
 * Created by aman on 27/1/17.
 */

public interface CustomerAddedProvider {

    void responseAddCustomer(int dsm_id,
                             int dse_id,
                             String customer_name,
                             int application_id,
                             String contact_no,
                             int district_id,
                             int town_id,
                             String tehsil,
                             int model_id,
                             int quantity,
                             int vehicle_id,
                             int financier_id,
                             int follow_up,
                             int geo_tag, CustomerAddedCallBack customerAddedCallBack);

}
