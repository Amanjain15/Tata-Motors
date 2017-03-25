package com.tata.motors.add_customer.model.data;

/**
 * Created by aman on 29/1/17.
 */

public class VehicleListDetails {

    private String vehicle_id;
    private String vehicle_name;

    public VehicleListDetails(String vehicle_id, String vehicle_name) {
        this.vehicle_id = vehicle_id;
        this.vehicle_name = vehicle_name;
    }

    public String getVehicle_id() {

        return vehicle_id;
    }

    public String getVehicle_name() {
        return vehicle_name;
    }
}
