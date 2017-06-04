package com.executives.motors.add_customer.model.data;

/**
 * Created by aman on 29/1/17.
 */

public class DseListDetails {

    private int  dse_id;
    private String dse_name;

    public DseListDetails(int dse_id, String dse_name) {
        this.dse_id = dse_id;
        this.dse_name = dse_name;
    }

    public int getDse_id() {
        return dse_id;
    }

    public String getDse_name() {
        return dse_name;
    }
}
