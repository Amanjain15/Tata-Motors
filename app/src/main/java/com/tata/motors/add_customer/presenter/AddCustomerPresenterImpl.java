package com.tata.motors.add_customer.presenter;

import com.tata.motors.add_customer.AddCustomerCallback;
import com.tata.motors.add_customer.model.AddCustomerProvider;
import com.tata.motors.add_customer.model.data.AddCustomerData;
import com.tata.motors.add_customer.view.AddCustomerView;

/**
 * Created by aman on 29/1/17.
 */

public class AddCustomerPresenterImpl implements AddCustomerPresenter {

    private AddCustomerProvider addCustomerProvider;
    private AddCustomerView addCustomerView;

    public AddCustomerPresenterImpl(AddCustomerProvider addCustomerProvider,
                                    AddCustomerView addCustomerView) {
        this.addCustomerProvider = addCustomerProvider;
        this.addCustomerView = addCustomerView;
    }

    @Override
    public void requestAddCustomer(String access_token, String user_id, String user_type) {

        addCustomerProvider.requestAddCustomer(access_token, user_id, user_type, new AddCustomerCallback() {
            @Override
            public void onSuccess(AddCustomerData addCustomerData) {
                if(addCustomerData.isSuccess())
                {


                }

                else
                {


                }
            }

            @Override
            public void onFailure(String error) {
                    addCustomerView.showError("No Internet Connection");
            }
        });
    }
}
