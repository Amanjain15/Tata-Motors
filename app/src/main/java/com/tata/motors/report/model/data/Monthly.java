package com.tata.motors.report.model.data;

/**
 * Created by iket on 23/1/17.
 */
public class Monthly {
    String dse_name;
    int customer_met,pending,sold,lost;

    public Monthly(String dse_name, int customer_name, int pending, int sold, int lost) {
        this.dse_name = dse_name;
        this.customer_met = customer_name;
        this.pending = pending;
        this.sold = sold;
        this.lost = lost;
    }


    public String getDse_name() {
        return dse_name;
    }

    public int getCustomer_met() {
        return customer_met;
    }

    public int getPending() {
        return pending;
    }

    public int getSold() {
        return sold;
    }

    public int getLost() {
        return lost;
    }
}
