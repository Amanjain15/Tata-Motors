package com.tata.motors.follow_up.view;


import com.tata.motors.follow_up.model.data.FollowUpListDetails;

import java.util.List;

/**
 * Created by aman on 11/4/17.
 */

public interface FollowUpView {

    void showProgressBar(boolean show);
    void showError(String error);
    void setDataValues(List<FollowUpListDetails> followUpListDetailses);
}
