package com.tata.motors.view_customer.model.data;

/**
 * Created by aman on 11/4/17.
 */

public class VehicleDataList {

    private String vehicle;
    private String model;
    private int quantity;

    public VehicleDataList(String vehicle, String model, int quantity) {
        this.vehicle = vehicle;
        this.model = model;
        this.quantity = quantity;
    }

    public String getVehicle_model_list() {
        return vehicle;
    }

    public String getVehicle_list() {
        return model;
    }

    public int getQuantity() {
        return quantity;
    }
}
