package com.tata.motors.add_customer.model;

import android.os.Handler;

import com.tata.motors.add_customer.CustomerAddedCallBack;
import com.tata.motors.add_customer.model.data.CustomerAddedData;

/**
 * Created by aman on 27/3/17.
 */

public class MockCustomerAdded implements CustomerAddedProvider {


    @Override
    public void responseAddCustomer(String access_token,int dsm_id, String customer_name,String address,String emai, String application_name,
                                    String contact_no, String district_name, String town_name,
                                    String tehsil, String json, String financier_name,
                                    String follow_up, int status, String location,final CustomerAddedCallBack customerAddedCallBack) {
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
