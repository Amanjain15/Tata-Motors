package com.tata.motors.add_user.presenter;

import com.tata.motors.add_user.AddUserCallBack;
import com.tata.motors.add_user.model.AddUserRetrofitProvider;
import com.tata.motors.add_user.model.data.AddUserData;
import com.tata.motors.add_user.view.AddUserFragment;
import com.tata.motors.add_user.view.AddUserView;

/**
 * Created by aman on 23/1/17.
 */

public class AddUserPresenterImpl implements AddUserPresenter{

    private AddUserRetrofitProvider addUserRetrofitProvider;
    private AddUserView addUserView;

    public AddUserPresenterImpl(AddUserFragment addUserView , AddUserRetrofitProvider addUserRetrofitProvider) {
        this.addUserView = addUserView;
        this.addUserRetrofitProvider = addUserRetrofitProvider;

    }

    @Override
    public void requestAddUser(String access_token, String user_id, String user_type,
                               String key_employee_type) {

        addUserRetrofitProvider.requestAddUser(access_token, user_id, user_type,
                key_employee_type, new AddUserCallBack() {
            @Override
            public void onSuccess(AddUserData addUserData) {

                if(addUserData.isSuccess())
                {
                    //addCustomerView.showSpinners(addCustomerData);
                    addUserView.check();
                }

                else
                {
                    //addCustomerView.showError("Something Went Wrong");
                    addUserView.showError(addUserData.getMessage());
                }

            }

            @Override
            public void onFailure() {
                addUserView.showError("No Internet Connection");
            }
        });


    }
}
