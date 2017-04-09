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
    public void requestAddCustomer(String access_token, int user_id, String user_type) {

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
    public void responseAddCustomer(int dsm_id,
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
                                    int geo_tag)
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
