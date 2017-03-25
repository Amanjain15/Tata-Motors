package com.tata.motors.add_customer.model.data;

/**
 * Created by aman on 29/1/17.
 */

public class FinancierListDetails {

    private String financier_id;
    private String financier_name;

    public FinancierListDetails(String financier_id, String financier_name) {
        this.financier_id = financier_id;
        this.financier_name = financier_name;
    }


    public String getFinancier_id() {
        return financier_id;
    }

    public String getFinancier_name() {
        return financier_name;
    }
}
