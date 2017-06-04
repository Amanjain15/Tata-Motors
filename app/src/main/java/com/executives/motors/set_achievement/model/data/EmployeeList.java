package com.executives.motors.set_achievement.model.data;

/**
 * Created by aman on 9/4/17.
 */

public class EmployeeList {
    private int id;
    private String name;

    public EmployeeList(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
