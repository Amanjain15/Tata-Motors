package com.tata.motors.follow_up.model.data;

import java.util.List;

/**
 * Created by aman on 11/4/17.
 */

public class FollowUpData {
    private boolean success;
    private String message;
    private List<FollowUpListDetails> followup_list;

    public FollowUpData(boolean success, String message, List<FollowUpListDetails> followup_list) {
        this.success = success;
        this.message = message;
        this.followup_list = followup_list;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<FollowUpListDetails> getFollow_up_details() {
        return followup_list;
    }
}
