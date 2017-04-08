package com.tata.motors.employee.model.data;

/**
 * Created by aman on 24/1/17.
 */
public class EmployeeListDetails {

    private int user_id;
    private String username;

    public EmployeeListDetails(int user_id, String username) {
        this.user_id = user_id;
        this.username = username;
    }


    public int getUser_id() {
        return user_id;
    }



    public String getUsername() {
        return username;
    }


}
