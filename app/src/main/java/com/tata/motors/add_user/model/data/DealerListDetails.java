package com.tata.motors.add_user.model.data;

/**
 * Created by aman on 27/1/17.
 */

public class DealerListDetails {

    private int dealer_id;
    private String dealer_name;


    public DealerListDetails(int dealer_id, String dealer_name) {
        this.dealer_id = dealer_id;
        this.dealer_name = dealer_name;
    }

    public int getDealer_id() {
        return dealer_id;
    }

    public String getDealer_name() {
        return dealer_name;
    }
}
