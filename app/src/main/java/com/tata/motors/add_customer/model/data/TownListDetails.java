package com.tata.motors.add_customer.model.data;

/**
 * Created by aman on 29/1/17.
 */

public class TownListDetails {

    private int  town_id;
    private String town_name;

    public TownListDetails(int town_id, String town_name) {
        this.town_id = town_id;
        this.town_name = town_name;
    }

    public int getTown_id() {
        return town_id;
    }

    public String getTown_name() {
        return town_name;
    }
}
