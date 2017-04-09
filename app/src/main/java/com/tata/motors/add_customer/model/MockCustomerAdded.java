package com.tata.motors.add_customer.model;

import android.os.Handler;

import com.tata.motors.add_customer.CustomerAddedCallBack;
import com.tata.motors.add_customer.model.data.CustomerAddedData;

/**
 * Created by aman on 27/3/17.
 */

public class MockCustomerAdded implements CustomerAddedProvider {
    @Override
    public void responseAddCustomer(int dsm_id, int dse_id, String customer_name,
                                    int  application_id, String contact_no, int district_id,
                                    int town_id, String tehsil, int model_id,int quantity,
                                    int vehicle_id, int financier_id, int follow_up,
                                    int geo_tag,
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
