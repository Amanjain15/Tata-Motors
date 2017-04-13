package com.tata.motors.add_customer.model.data;



import java.util.List;

/**
 * Created by aman on 12/4/17.
 */

public class EditCustomerData {
    private boolean success;
    private String message;
    private int customer_id;
    private String customer_name;
    private String address;
    private String contact_no;
    private String email;
    private String application_name;
    private String district_name;
    private String town_name;
    private String tehsil;
    private List<VehicleDataList> vehicle_selected_data_list;
    private String financier_name;
    private String followup;
    private int status;
    private String location;

    List<DsmListDetails> user_list;
    List<ApplicationListDetails> application_list;
    List<DistrictListDetails> district_list;
    List<TownListDetails> town_list;
    List<FinancierListDetails> financier_list;
    List<ModelListDetails> vehicle_model_list;
    List<VehicleListDetails> vehicle_list;

    public EditCustomerData(boolean success, String message, int customer_id,
                            String customer_name, String address, String contact_no,
                            String email, String application_name, String district_name,
                            String town_name, String tehsil, List<VehicleDataList> vehicle_selected_data_list,
                            String financier_name, String follow_up, int status, String location,
                            List<DsmListDetails> user_list,
                            List<ApplicationListDetails> application_list,
                            List<DistrictListDetails> district_list, List<TownListDetails> town_list,
                            List<FinancierListDetails> financier_list, List<ModelListDetails> vehicle_model_list,
                            List<VehicleListDetails> vehicle_list) {
        this.success = success;
        this.message = message;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.address = address;
        this.contact_no = contact_no;
        this.email = email;
        this.application_name = application_name;
        this.district_name = district_name;
        this.town_name = town_name;
        this.tehsil = tehsil;
        this.vehicle_selected_data_list = vehicle_selected_data_list;
        this.financier_name = financier_name;
        this.followup = follow_up;
        this.status = status;
        this.location = location;
        this.application_list = application_list;
        this.district_list = district_list;
        this.town_list = town_list;
        this.financier_list = financier_list;
        this.vehicle_model_list = vehicle_model_list;
        this.vehicle_list = vehicle_list;
        this.user_list=user_list;
    }
    public List<DsmListDetails> getDsmListDetails() {
        return user_list;
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

    public String getEmail() {
        return email;
    }

    public String getApplication_name() {
        return application_name;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public String getTown_name() {
        return town_name;
    }

    public String getTehsil() {
        return tehsil;
    }

    public List<VehicleDataList> getVehicle_data_list() {
        return vehicle_selected_data_list;
    }

    public String getFinancier_name() {
        return financier_name;
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

    public List<ApplicationListDetails> getApplication_list() {
        return application_list;
    }

    public List<DistrictListDetails> getDistrict_list() {
        return district_list;
    }

    public List<TownListDetails> getTown_list() {
        return town_list;
    }

    public List<FinancierListDetails> getFinancier_list() {
        return financier_list;
    }

    public List<ModelListDetails> getVehicle_model_list() {
        return vehicle_model_list;
    }

    public List<VehicleListDetails> getVehicle_list() {
        return vehicle_list;
    }
}
