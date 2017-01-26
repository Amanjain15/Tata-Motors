package com.tata.motors.add_user.view;

import com.tata.motors.add_user.model.data.DealerListDetails;
import com.tata.motors.add_user.model.data.DsmListDetails;

/**
 * Created by aman on 23/1/17.
 */

public interface AddUserView {


    void showSpinnerDsm(DsmListDetails dsmListDetails);
    void showSpinnerDealer(DealerListDetails dealerListDetails);
    void showError(String message);
    void showDialog();





}
