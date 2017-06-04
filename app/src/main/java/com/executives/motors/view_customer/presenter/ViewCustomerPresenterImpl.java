package com.executives.motors.view_customer.presenter;

import com.executives.motors.view_customer.ViewCustomerCallBack;
import com.executives.motors.view_customer.model.ViewCustomerProvider;
import com.executives.motors.view_customer.model.data.ViewCustomerData;
import com.executives.motors.view_customer.view.ViewCustomer;

/**
 * Created by aman on 11/4/17.
 */

public class ViewCustomerPresenterImpl implements ViewCustomerPresenter {

    private ViewCustomer viewCustomer;
    private ViewCustomerProvider viewCustomerProvider;

    public ViewCustomerPresenterImpl(ViewCustomer viewCustomer, ViewCustomerProvider viewCustomerProvider) {
        this.viewCustomer = viewCustomer;
        this.viewCustomerProvider = viewCustomerProvider;
    }

    @Override
    public void requestViewCustomer(String access_token, int customer_id) {
        viewCustomer.showProgressBar(true);
        viewCustomerProvider.requestViewCustomer(access_token, customer_id, new ViewCustomerCallBack() {
            @Override
            public void onSuccess(ViewCustomerData viewCustomerData) {
                if(viewCustomerData.isSuccess())
                {
                    viewCustomer.showProgressBar(false);
                    viewCustomer.setData(viewCustomerData);
                    viewCustomer.showError(viewCustomerData.getMessage());
                }
                else
                {
                    viewCustomer.showProgressBar(false);
                    viewCustomer.showError(viewCustomerData.getMessage());
                }
            }

            @Override
            public void onFailure(String error) {
                viewCustomer.showProgressBar(false);
                viewCustomer.showError(error);
            }
        });
    }
}
