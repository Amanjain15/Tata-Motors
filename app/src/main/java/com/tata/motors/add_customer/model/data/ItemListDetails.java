package com.tata.motors.add_customer.model.data;

/**
 * Created by aman on 10/4/17.
 */

public class ItemListDetails {
    private int quantity;
    private String vehicle_name;
    private String model_name;

    public ItemListDetails(int quantity, String vehicle_name, String model_name) {
        this.quantity = quantity;
        this.vehicle_name = vehicle_name;
        this.model_name = model_name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }
}
