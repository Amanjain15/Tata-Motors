package com.tata.motors.add_user.model.data;

/**
 * Created by aman on 27/1/17.
 */

public class DealerListDetails {

    private String dealer_id;
    private String dealer_name;


    public DealerListDetails(String dealer_id, String dealer_name) {
        this.dealer_id = dealer_id;
        this.dealer_name = dealer_name;
    }


    public String getDealer_id() {
        return dealer_id;
    }

    public String getDealer_name() {
        return dealer_name;
    }
}
