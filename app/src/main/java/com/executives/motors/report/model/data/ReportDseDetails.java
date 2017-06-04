package com.executives.motors.report.model.data;

/**
 * Created by aman on 10/4/17.
 */

public class ReportDseDetails {
    private String name,sold,lost,pending,customer_met;

    public ReportDseDetails(String name, String sold, String lost, String pending, String customer_met) {
        this.name = name;
        this.sold = sold;
        this.lost = lost;
        this.pending = pending;
        this.customer_met = customer_met;
    }


    public String getName() {
        return name;
    }

    public String getSold() {
        return sold;
    }

    public String getLost() {
        return lost;
    }

    public String getPending() {
        return pending;
    }

    public String getCustomer_met() {
        return customer_met;
    }
}
