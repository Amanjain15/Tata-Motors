package com.executives.motors.follow_up.model.data;

/**
 * Created by aman on 11/4/17.
 */

public class FollowUpListDetails {

    private String name;
    private String date;

    public FollowUpListDetails(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}
