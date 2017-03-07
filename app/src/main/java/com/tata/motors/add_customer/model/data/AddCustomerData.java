package com.tata.motors.add_customer.model.data;

import java.util.List;

/**
 * Created by aman on 27/1/17.
 */

public class AddCustomerData {
    private boolean success;
    private String message;
    private int user_type;
    List<ApplicationListDetails> applicationListDetails;
    List<DistrictListDetails> districtListDetails;
    List<TownListDetails> townListDetails;
    List<FinancierListDetails> financierListDetails;
    List<ModelListDetails> modelListDetails;
    List<VehicleListDetails> vehicleListDetails;
    List<DsmListDetails> dsmListDetails;
    List<DseListDetails> dseListDetails;

    public AddCustomerData(boolean success, String message, int user_type,
                           List<ApplicationListDetails> applicationListDetails,
                           List<DistrictListDetails> districtListDetails,
                           List<TownListDetails> townListDetails,
                           List<FinancierListDetails> financierListDetails,
                           List<ModelListDetails> modelListDetails,
                           List<VehicleListDetails> vehicleListDetails,
                           List<DsmListDetails> dsmListDetails,
                           List<DseListDetails> dseListDetails) {
        this.success = success;
        this.message = message;
        this.user_type = user_type;
        this.applicationListDetails = applicationListDetails;
        this.districtListDetails = districtListDetails;
        this.townListDetails = townListDetails;
        this.financierListDetails = financierListDetails;
        this.modelListDetails = modelListDetails;
        this.vehicleListDetails = vehicleListDetails;
        this.dsmListDetails = dsmListDetails;
        this.dseListDetails = dseListDetails;
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
        return applicationListDetails;
    }

    public List<DistrictListDetails> getDistrictListDetails() {
        return districtListDetails;
    }

    public List<TownListDetails> getTownListDetails() {
        return townListDetails;
    }

    public List<FinancierListDetails> getFinancierListDetails() {
        return financierListDetails;
    }

    public List<ModelListDetails> getModelListDetails() {
        return modelListDetails;
    }

    public List<VehicleListDetails> getVehicleListDetails() {
        return vehicleListDetails;
    }

    public List<DsmListDetails> getDsmListDetails() {
        return dsmListDetails;
    }

    public List<DseListDetails> getDseListDetails() {
        return dseListDetails;
    }
}
