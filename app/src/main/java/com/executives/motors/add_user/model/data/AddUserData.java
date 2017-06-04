package com.executives.motors.add_user.model.data;

import java.util.List;

/**
 * Created by aman on 23/1/17.
 */

public class AddUserData {

    private boolean success;
    private String message;
    private int user_type;
    private List<DsmListDetails> dsm_list;
    private List<DealerListDetails> dealer_list;

    public AddUserData(List<DealerListDetails> dealer_list) {
        this.dealer_list = dealer_list;
    }


    public AddUserData(boolean success, String message, int user_type, List<DsmListDetails> dsm_list,
                       List<DealerListDetails> dealer_list)
    {
        this.success = success;
        this.message = message;
        this.user_type = user_type;
        this.dsm_list = dsm_list;
        this.dealer_list = dealer_list;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public int getUser_type() {
        return user_type;
    }

    public List<DsmListDetails> getDsm_list() {
        return dsm_list;
    }

    public List<DealerListDetails> getDealer_list() {
        return dealer_list;
    }
}

