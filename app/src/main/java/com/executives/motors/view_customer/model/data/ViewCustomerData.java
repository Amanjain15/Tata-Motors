package com.executives.motors.view_customer.model.data;


import java.util.List;

/**
 * Created by aman on 11/4/17.
 */

public class ViewCustomerData {

    private boolean success;
    private String message;
    private int customer_id;
    private String customer_name;
    private String address;
    private String contact_no;
    private String email;
    private String application;
    private String district;
    private String town;
    private String tehsil;
    private List<VehicleDataList> vehicle_selected_data_list;
    private String financier;
    private String followup;
    private int status;
    private String location;

    public ViewCustomerData(boolean success, String message, int customer_id, String customer_name
                            , String email, String address, String contact_no, String application,
                            String district, String town, String tehsil,
                            List<VehicleDataList> vehicle_selected_data_list, String financier_name,
                            String followup, int status, String location) {
        this.success = success;
        this.message = message;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.address = address;
        this.contact_no = contact_no;
        this.application = application;
        this.district = district;
        this.town = town;
        this.tehsil = tehsil;
        this.vehicle_selected_data_list = vehicle_selected_data_list;
        this.financier = financier_name;
        this.followup = followup;
        this.status = status;
        this.location = location;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact_no() {
        return contact_no;
    }

    public String getApplication() {
        return application;
    }

    public String getDistrict() {
        return district;
    }

    public String getTown() {
        return town;
    }

    public String getTehsil() {
        return tehsil;
    }

    public List<VehicleDataList> getVehicle_data_list() {
        return vehicle_selected_data_list;
    }

    public String getFinancier() {
        return financier;
    }

    public String getFollow_up() {
        return followup;
    }

    public int getStatus() {
        return status;
    }

    public String getLocation() {
        return location;
    }
}
