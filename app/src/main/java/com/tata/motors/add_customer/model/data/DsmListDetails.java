package com.tata.motors.add_customer.model.data;

/**
 * Created by aman on 29/1/17.
 */

public class DsmListDetails {

    private int id;
    private String name;

    public DsmListDetails(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getDsm_id() {
        return id;
    }

    public String getDsm_name() {
        return name;
    }
}
