package com.executives.motors.targets.model.data;

import java.util.List;

/**
 * Created by aman on 6/3/17.
 */

public class TargetDataTsm {

    private boolean success;
    private String message;
    private List<TargetListDetails> targetListDetails;

    public TargetDataTsm(boolean success, String message, List<TargetListDetails> targetListDetails) {
        this.success = success;
        this.message = message;
        this.targetListDetails = targetListDetails;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<TargetListDetails> getTargetListDetails() {
        return targetListDetails;
    }
}
