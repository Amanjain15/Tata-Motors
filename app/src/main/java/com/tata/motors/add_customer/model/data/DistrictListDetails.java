package com.tata.motors.add_customer.model.data;

/**
 * Created by aman on 29/1/17.
 */

public class DistrictListDetails {

    private int district_id;
    private String district_name;

    public DistrictListDetails(int district_id, String district_name) {
        this.district_id = district_id;
        this.district_name = district_name;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public String getDistrict_name() {
        return district_name;
    }
}
