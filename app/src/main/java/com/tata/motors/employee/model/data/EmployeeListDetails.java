package com.tata.motors.employee.model.data;

/**
 * Created by aman on 24/1/17.
 */
public class EmployeeListDetails {

    private int id;
    private String name;

    public EmployeeListDetails(int user_id, String username) {
        this.id = user_id;
        this.name = username;
    }


    public int getUser_id() {
        return id;
    }



    public String getUsername() {
        return name;
    }


}
