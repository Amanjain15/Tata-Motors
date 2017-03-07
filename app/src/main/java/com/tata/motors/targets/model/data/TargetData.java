package com.tata.motors.targets.model.data;

import java.util.List;

/**
 * Created by aman on 6/3/17.
 */

public class TargetData {

    private boolean success;
    private String message;
    private List<TargetListDetails> targetListDetails;

    public TargetData(boolean success, String message, List<TargetListDetails> targetListDetails) {
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

    public void setTargetListDetails(List<TargetListDetails> targetListDetails) {
        this.targetListDetails = targetListDetails;
    }
}
