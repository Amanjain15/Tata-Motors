package com.tata.motors.add_user.presenter;

import com.tata.motors.add_user.UserAddedCallBack;
import com.tata.motors.add_user.model.UserAddedProvider;
import com.tata.motors.add_user.model.data.UserAddedData;
import com.tata.motors.add_user.view.AddUserView;

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
    public void responseAddUser(String dealer_id,String dsm_id, String username, String name ) {
        userAddedProvider.responseAddUser(dealer_id,dsm_id, username, name,new UserAddedCallBack() {
            @Override
            public void onSuccess(UserAddedData userAddedData) {

                addUserView.showDialog();
            }

            @Override
            public void onFailure(String error) {
                addUserView.showError(error);
            }
        });

    }
}
