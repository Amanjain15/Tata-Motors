package com.tata.motors.add_user.view;

import com.tata.motors.add_user.model.data.AddUserData;
import com.tata.motors.add_user.model.data.DealerListDetails;
import com.tata.motors.add_user.model.data.DsmListDetails;

/**
 * Created by aman on 23/1/17.
 */

public interface AddUserView {


    void showSpinnerDsm(AddUserData addUserData);
    void showSpinnerDealer(AddUserData addUserData);
    void showError(String message);
    void showDialog();
    void check(AddUserData addUserData);





}
