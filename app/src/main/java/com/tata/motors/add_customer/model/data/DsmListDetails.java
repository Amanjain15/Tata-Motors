package com.tata.motors.add_customer.model.data;

/**
 * Created by aman on 29/1/17.
 */

public class DsmListDetails {

    private int dsm_id;
    private String dsm_name;

    public DsmListDetails(int dsm_id, String dsm_name) {
        this.dsm_id = dsm_id;
        this.dsm_name = dsm_name;
    }

    public int getDsm_id() {
        return dsm_id;
    }

    public String getDsm_name() {
        return dsm_name;
    }
}
