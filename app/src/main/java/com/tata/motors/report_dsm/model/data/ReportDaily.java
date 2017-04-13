package com.tata.motors.report_dsm.model.data;

/**
 * Created by aman on 12/4/17.
 */

public class ReportDaily {
    private int lost, sold, customer_met, pending;
    private int flag,id;
    private String  name;

    public ReportDaily(int lost, int sold, int customer_met, int pending, int flag, int id, String name) {
        this.lost = lost;
        this.sold = sold;
        this.customer_met = customer_met;
        this.pending = pending;
        this.flag = flag;
        this.id = id;
        this.name = name;
    }

    public int getLost() {
        return lost;
    }

    public int getSold() {
        return sold;
    }

    public int getCustomer_met() {
        return customer_met;
    }

    public int getPending() {
        return pending;
    }

    public int getFlag() {
        return flag;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}