package com.tata.motors.add_customer.model.data;

import java.util.List;

/**
 * Created by aman on 27/1/17.
 */

public class AddCustomerData {
    private boolean success;
    private String message;
    private int user_type;
    List<ApplicationListDetails> applicationList;
    List<DistrictListDetails> districtList;
    List<TownListDetails> townList;
    List<FinancierListDetails> financierList;
    List<ModelListDetails> modelList;
    List<VehicleListDetails> vehicleList;
    List<DsmListDetails> user_list;

    public AddCustomerData(boolean success, String message, int user_type,
                           List<ApplicationListDetails> applicationList,
                           List<DistrictListDetails> districtList,
                           List<TownListDetails> townList,
                           List<FinancierListDetails> financierList,
                           List<ModelListDetails> modelList,
                           List<VehicleListDetails> vehicleList,
                           List<DsmListDetails> user_list) {
        this.success = success;
        this.message = message;
        this.user_type = user_type;
        this.applicationList = applicationList;
        this.districtList = districtList;
        this.townList = townList;
        this.financierList= financierList;
        this.modelList= modelList;
        this.vehicleList= vehicleList;
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
        return applicationList;
    }

    public List<DistrictListDetails> getDistrictListDetails() {
        return districtList;
    }

    public List<TownListDetails> getTownListDetails() {
        return townList;
    }

    public List<FinancierListDetails> getFinancierListDetails() {
        return financierList;
    }

    public List<ModelListDetails> getModelListDetails() {
        return modelList;
    }

    public List<VehicleListDetails> getVehicleListDetails() {
        return vehicleList;
    }

    public List<DsmListDetails> getDsmListDetails() {
        return user_list;
    }
}
