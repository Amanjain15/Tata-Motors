package com.tata.motors.add_customer.view;

import com.tata.motors.add_customer.model.data.EditCustomerData;

/**
 * Created by aman on 12/4/17.
 */

public interface EditCustomerView {

    void showAdd();
    void showProgressBar(boolean show);
    void showError(String error);
    void showData(EditCustomerData editCustomerData);
    void setData(int i );
    void setValues(int i,int id,String vehicle,String model,int quantity);
    void intent();
}
