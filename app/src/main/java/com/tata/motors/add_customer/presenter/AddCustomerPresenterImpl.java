package com.tata.motors.add_customer.presenter;

import com.tata.motors.add_customer.AddCustomerCallback;
import com.tata.motors.add_customer.CustomerAddedCallBack;
import com.tata.motors.add_customer.model.AddCustomerProvider;
import com.tata.motors.add_customer.model.CustomerAddedProvider;
import com.tata.motors.add_customer.model.data.AddCustomerData;
import com.tata.motors.add_customer.model.data.CustomerAddedData;
import com.tata.motors.add_customer.view.AddCustomerView;

/**
 * Created by aman on 29/1/17.
 */

public class AddCustomerPresenterImpl implements AddCustomerPresenter {

    private AddCustomerProvider addCustomerProvider;
    private AddCustomerView addCustomerView;
    private CustomerAddedProvider customerAddedProvider;

    public AddCustomerPresenterImpl(AddCustomerProvider addCustomerProvider,
                                    AddCustomerView addCustomerView) {
        this.addCustomerProvider = addCustomerProvider;
        this.addCustomerView = addCustomerView;
    }

    public AddCustomerPresenterImpl(CustomerAddedProvider customerAddedProvider) {
        this.customerAddedProvider = customerAddedProvider;
    }

    @Override
    public void requestAddCustomer(String access_token, String user_id, String user_type) {

        addCustomerProvider.requestAddCustomer(access_token, user_id, user_type, new AddCustomerCallback() {
            @Override
            public void onSuccess(AddCustomerData addCustomerData) {
                if(addCustomerData.isSuccess())
                {
                    addCustomerView.showSpinners(addCustomerData);
//                    addCustomerView.showSpinnerDsm(addCustomerData.getDsmListDetails());
//                    addCustomerView.showSpinnerDse(addCustomerData);
                }

                else
                {
                    addCustomerView.showError("Something Went Wrong");

                }
            }

            @Override
            public void onFailure(String error) {
                    addCustomerView.showError("No Internet Connection");
            }
        });
    }

    @Override
    public void responseAddCustomer(String dsm_id, String dse_id, String customer_name,
                                    String application_id, String contact_no, String district_id,
                                    String town_id, String tehsil, String model_id, String quantity,
                                    String vehicle_id, String financier_id, int follow_up, String geo_tag)
    {
        addCustomerView.showProgressBar(true);
        customerAddedProvider.responseAddCustomer(dsm_id, dse_id, customer_name, application_id, contact_no, district_id,
                town_id, tehsil, model_id, quantity, vehicle_id, financier_id, follow_up,
                geo_tag, new CustomerAddedCallBack() {
                    @Override
                    public void onSuccess(CustomerAddedData customerAddedData) {
                        if(customerAddedData.isSuccess())
                        {

                            addCustomerView.showError(customerAddedData.getMessage());
                            addCustomerView.showProgressBar(false);
                        }
                        else{

                            addCustomerView.showError(customerAddedData.getMessage());
                            addCustomerView.showProgressBar(false);
                        }
                    }

                    @Override
                    public void onFailure(String error) {
                        addCustomerView.showProgressBar(false);
                        addCustomerView.showError("Try Again Later");

                    }
                });


    }
}
