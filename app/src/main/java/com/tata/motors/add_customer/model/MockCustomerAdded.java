package com.tata.motors.add_customer.model;

import android.os.Handler;

import com.tata.motors.add_customer.CustomerAddedCallBack;
import com.tata.motors.add_customer.model.data.CustomerAddedData;

/**
 * Created by aman on 27/3/17.
 */

public class MockCustomerAdded implements CustomerAddedProvider {
    @Override
    public void responseAddCustomer(String dsm_id, String dse_id, String customer_name,
                                    String application_id, String contact_no, String district_id,
                                    String town_id, String tehsil, String model_id, String quantity,
                                    String vehicle_id, String financier_id, int follow_up,
                                    String geo_tag,
                                    final CustomerAddedCallBack customerAddedCallBack)

    {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                customerAddedCallBack.onSuccess(getMockCustomerAdded());
            }
        },500);

    }

    private CustomerAddedData getMockCustomerAdded(){

        CustomerAddedData customerAddedData = new CustomerAddedData(true,"Success");
        return customerAddedData;
    }



}
