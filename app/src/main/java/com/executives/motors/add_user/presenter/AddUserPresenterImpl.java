package com.executives.motors.add_user.presenter;

import com.executives.motors.add_user.AddUserCallBack;
import com.executives.motors.add_user.model.AddUserProvider;
import com.executives.motors.add_user.model.data.AddUserData;
import com.executives.motors.add_user.view.AddUserFragment;
import com.executives.motors.add_user.view.AddUserView;

/**
 * Created by aman on 23/1/17.
 */

public class AddUserPresenterImpl implements AddUserPresenter{

    private AddUserProvider addUserRetrofitProvider;
    private AddUserView addUserView;

    public AddUserPresenterImpl(AddUserFragment addUserView , AddUserProvider addUserRetrofitProvider) {
        this.addUserView = addUserView;
        this.addUserRetrofitProvider = addUserRetrofitProvider;

    }

    @Override
    public void requestAddUser(String access_token, int user_id,
                               String key_employee_type) {

        addUserRetrofitProvider.requestAddUser(access_token, user_id,
                key_employee_type, new AddUserCallBack() {
            @Override
            public void onSuccess(AddUserData addUserData) {

                if(addUserData.isSuccess())
                {
                    //addCustomerView.showSpinners(addCustomerData);
                    addUserView.check(addUserData);
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
