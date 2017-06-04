package com.executives.motors.add_customer.presenter;

import com.executives.motors.add_customer.CustomerAddedCallBack;
import com.executives.motors.add_customer.EditCustomerCallBack;
import com.executives.motors.add_customer.model.EditCustomerProvider;
import com.executives.motors.add_customer.model.data.CustomerAddedData;
import com.executives.motors.add_customer.model.data.EditCustomerData;
import com.executives.motors.add_customer.view.EditCustomerView;

/**
 * Created by aman on 12/4/17.
 */

public class EditCustomerPresenterImpl implements  EditCustomerPresenter {

    private EditCustomerView editCustomerView;
    private EditCustomerProvider editCustomerProvider;

    public EditCustomerPresenterImpl(EditCustomerView editCustomerView, EditCustomerProvider editCustomerProvider) {
        this.editCustomerView = editCustomerView;
        this.editCustomerProvider = editCustomerProvider;
    }

    @Override
    public void requestEditCustomer(String access_token, int choose_id) {

        editCustomerView.showProgressBar(true);
        editCustomerProvider.requestEditCustomer(access_token, choose_id, new EditCustomerCallBack() {
            @Override
            public void onSuccess(EditCustomerData editCustomerData) {
                if(editCustomerData.isSuccess())
                {
                    editCustomerView.showProgressBar(false);
                    editCustomerView.showData(editCustomerData);
                    editCustomerView.showError(editCustomerData.getMessage());
                }
                else{
                    editCustomerView.showProgressBar(false);
                    editCustomerView.showError(editCustomerData.getMessage());
                }
            }

            @Override
            public void onFailure(String error) {
                editCustomerView.showProgressBar(false);
                editCustomerView.showError(error);
            }
        });


    }

    @Override
    public void responseEditCustomer(String access_token,int dsm_id ,int choose_id, String customer_name,
                                     String address,String email, String application_name, String contact_no,
                                     String district_name, String town_name, String tehsil,
                                     String json, String financier_name, String follow_up, int status, String location) {
        editCustomerView.showProgressBar(true);
        editCustomerProvider.responseEditCustomer(access_token,dsm_id, choose_id, customer_name, address,email,
                application_name, contact_no, district_name,
                town_name, tehsil, json, financier_name, follow_up,
                status, location, new CustomerAddedCallBack() {
                    @Override
                    public void onSuccess(CustomerAddedData customerAddedData) {
                        if(customerAddedData.isSuccess())
                        {

                            editCustomerView.showError(customerAddedData.getMessage());
                            editCustomerView.showProgressBar(false);
                            editCustomerView.intent();
                            //// TODO: 10/4/17 HAVE to intent to another fragment necessary
                        }
                        else{

                            editCustomerView.showError(customerAddedData.getMessage());
                            editCustomerView.showProgressBar(false);
                        }
                    }

                    @Override
                    public void onFailure(String error) {
                        editCustomerView.showError(error);
                        editCustomerView.showProgressBar(false);
                    }
                });
    }
}
