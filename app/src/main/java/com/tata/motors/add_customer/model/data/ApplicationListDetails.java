package com.tata.motors.add_customer.model.data;

/**
 * Created by aman on 29/1/17.
 */

public class ApplicationListDetails {

    private String application_id;
    private String application_name;

    public ApplicationListDetails(String application_id, String application_name) {
        this.application_id = application_id;
        this.application_name = application_name;
    }

    public String getApplication_id() {
        return application_id;
    }

    public String getApplication_name() {
        return application_name;
    }
}
