package com.tata.motors.add_customer.model.data;

import java.util.List;

/**
 * Created by aman on 27/1/17.
 */

public class AddCustomerData {
    private boolean success;
    private String message;
    private int user_type;
    List<ApplicationListDetails> application_list;
    List<DistrictListDetails> district_list;
    List<TownListDetails> town_list;
    List<FinancierListDetails> financier_list;
    List<ModelListDetails> vehicle_model_list;
    List<VehicleListDetails> vehicle_list;
    List<DsmListDetails> user_list;

    public AddCustomerData(boolean success, String message, int user_type,
                           List<ApplicationListDetails> application_list,
                           List<DistrictListDetails> district_list,
                           List<TownListDetails> town_list,
                           List<FinancierListDetails> financier_list,
                           List<ModelListDetails> vehicle_model_list,
                           List<VehicleListDetails> vehicle_list,
                           List<DsmListDetails> user_list) {
        this.success = success;
        this.message = message;
        this.user_type = user_type;
        this.application_list = application_list;
        this.district_list = district_list;
        this.town_list = town_list;
        this.financier_list = financier_list;
        this.vehicle_model_list = vehicle_model_list;
        this.vehicle_list = vehicle_list;
        this.user_list = user_list;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public int getUser_type() {
        return user_type;
    }

    public List<ApplicationListDetails> getApplicationListDetails() {
        return application_list;
    }

    public List<DistrictListDetails> getDistrictListDetails() {
        return district_list;
    }

    public List<TownListDetails> getTownListDetails() {
        return town_list;
    }

    public List<FinancierListDetails> getFinancierListDetails() {
        return financier_list;
    }

    public List<ModelListDetails> getModelListDetails() {
        return vehicle_model_list;
    }

    public List<VehicleListDetails> getVehicleListDetails() {
        return vehicle_list;
    }

    public List<DsmListDetails> getDsmListDetails() {
        return user_list;
    }
}
