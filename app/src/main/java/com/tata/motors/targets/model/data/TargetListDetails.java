package com.tata.motors.targets.model.data;

/**
 * Created by aman on 6/3/17.
 */

public class TargetListDetails {

    private String user_id;
    private String username;
    private String monthly;
    private String daily;

    public TargetListDetails(String user_id, String username, String monthly, String daily) {
        this.user_id = user_id;
        this.username = username;
        this.monthly = monthly;
        this.daily = daily;
    }

    public String getUser_id() {

        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getMonthly() {
        return monthly;
    }

    public String getDaily() {
        return daily;
    }

    public void setMonthly(String monthly) {
        this.monthly = monthly;
    }

    public void setDaily(String daily) {
        this.daily = daily;
    }
}
