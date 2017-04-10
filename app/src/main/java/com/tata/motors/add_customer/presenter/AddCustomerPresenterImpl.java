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
    public void requestAddCustomer(String access_token) {

        addCustomerProvider.requestAddCustomer(access_token, new AddCustomerCallback() {
            @Override
            public void onSuccess(AddCustomerData addCustomerData) {
                if(addCustomerData.isSuccess())
                {
                    addCustomerView.showSpinners(addCustomerData);
                    addCustomerView.showError(addCustomerData.getMessage());
//                    addCustomerView.showSpinnerDsm(addCustomerData.getDsmListDetails());
//                    addCustomerView.showSpinnerDse(addCustomerData);
                }

                else
                {
                    addCustomerView.showError(addCustomerData.getMessage());

                }
            }

            @Override
            public void onFailure(String error) {
                    addCustomerView.showError("No Internet Connection");
            }
        });
    }

    @Override
    public void responseAddCustomer(int dsm_id,
                                    String customer_name,
                                    String application_name,
                                    String contact_no,
                                    String district_name,
                                    String town_name,
                                    String tehsil,
                                    String json,
                                    String financier_name,
                                    String follow_up,
                                    int status ,String location)
    {
        addCustomerView.showProgressBar(true);
        customerAddedProvider.responseAddCustomer(dsm_id,customer_name, application_name,contact_no, district_name,
                town_name, tehsil, json, financier_name, follow_up,
                status,location, new CustomerAddedCallBack() {
                    @Override
                    public void onSuccess(CustomerAddedData customerAddedData) {
                        if(customerAddedData.isSuccess())
                        {

                            addCustomerView.showError(customerAddedData.getMessage());
                            addCustomerView.showProgressBar(false);
                            //// TODO: 10/4/17 HAVE to intent to another fragment necessary
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
