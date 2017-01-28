package com.tata.motors.add_customer.model.data;

/**
 * Created by aman on 29/1/17.
 */

public class ModelListDetails {

    private String model_id;
    private String model_name;

    public ModelListDetails(String model_id, String model_name) {
        this.model_id = model_id;
        this.model_name = model_name;
    }

    public String getModel_id() {
        return model_id;
    }

    public String getModel_name() {
        return model_name;
    }
}
