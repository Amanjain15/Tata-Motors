package com.tata.motors.add_user.model.data;

/**
 * Created by aman on 23/1/17.
 */

public class DsmListDetails {

    private String dsm_id;
    private String dsm_name;

    public DsmListDetails(String dsm_id, String dsm_name) {
        this.dsm_id = dsm_id;
        this.dsm_name = dsm_name;
    }


    public String getDsm_id() {
        return dsm_id;
    }

    public String getDsm_name() {
        return dsm_name;
    }
}
