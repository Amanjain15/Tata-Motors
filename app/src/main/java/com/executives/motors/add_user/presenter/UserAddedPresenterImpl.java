package com.executives.motors.add_user.presenter;

import com.executives.motors.add_user.UserAddedCallBack;
import com.executives.motors.add_user.model.UserAddedProvider;
import com.executives.motors.add_user.model.data.UserAddedData;
import com.executives.motors.add_user.view.AddUserView;

/**
 * Created by aman on 24/1/17.
 */

public class UserAddedPresenterImpl implements UserAddedPresenter{

    private AddUserView addUserView;
    private UserAddedProvider userAddedProvider;


    public UserAddedPresenterImpl(AddUserView addUserView, UserAddedProvider userAddedProvider) {
        this.addUserView = addUserView;
        this.userAddedProvider = userAddedProvider;
    }

    @Override
    public void responseAddUser(String access_token,int dealer_id, String username, String name ,
                                String key_employee_type) {
        userAddedProvider.responseAddUser(access_token,dealer_id, username, name,key_employee_type,new UserAddedCallBack() {
            @Override
            public void onSuccess(UserAddedData userAddedData) {

                if(userAddedData.isSuccess())
                addUserView.showDialog(userAddedData);
                else
                    addUserView.showError(userAddedData.getMessage());
            }

            @Override
            public void onFailure(String error) {
                addUserView.showError(error);
            }
        });

    }
}
