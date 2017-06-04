package com.executives.motors.add_customer.model.data;

/**
 * Created by aman on 11/4/17.
 */

public class VehicleDataList {

    private String model;
    private String vehicle;
    private int quantity;
    private int id;

    public VehicleDataList(String model, String vehicle, int quantity,int id) {
        this.model = model;
        this.vehicle = vehicle;
        this.quantity = quantity;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public String getVehicle_model_list() {
        return model;
    }

    public String getVehicle_list() {
        return vehicle;
    }

    public int getQuantity() {
        return quantity;
    }
}
