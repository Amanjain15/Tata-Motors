package com.tata.motors.add_customer.presenter;

/**
 * Created by aman on 29/1/17.
 */

public interface AddCustomerPresenter {

    void requestAddCustomer(String access_token, int user_id, String user_type);
    void responseAddCustomer( int dsm_id,
                              int dse_id,
                              String customer_name,
                              int application_id,
                              String contact_no,
                              int district_id,
                              int town_id,
                              String tehsil,
                              int model_id,
                              int quantity,
                              int vehicle_id,
                              int financier_id,
                              int follow_up,
                              int geo_tag);
}
