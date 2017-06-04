package com.executives.motors.achievement.model.data;

/**
 * Created by aman on 9/4/17.
 */

public class AchievementDataDetails {

    private  String sender_name;
    private  String sender_designation,name,designation,message;

    public AchievementDataDetails(String sender_name, String sender_designation, String name, String designation, String message) {
        this.sender_name = sender_name;
        this.sender_designation = sender_designation;
        this.name = name;
        this.designation = designation;
        this.message = message;
    }

    public String getSender_name() {
        return sender_name;
    }

    public String getSender_designation() {
        return sender_designation;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getMessage() {
        return message;
    }
}
