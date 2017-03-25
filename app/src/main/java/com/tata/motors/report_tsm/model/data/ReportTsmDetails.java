package com.tata.motors.report_tsm.model.data;

/**
 * Created by aman on 8/3/17.
 */
public class ReportTsmDetails {
   private  String dsmName;
   private  String customerMet;
    private String pending;
    private String sold;
    private  String lost;

    public String getCustomerMet() {
        return customerMet;
    }

    public void setCustomerMet(String customerMet) {
        this.customerMet = customerMet;
    }

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }

    public String getLost() {
        return lost;
    }

    public void setLost(String lost) {
        this.lost = lost;
    }

    private  String dsmId;

    public String getDsmId() {
        return dsmId;
    }

    public void setDsmId(String dsmId) {
        this.dsmId = dsmId;
    }

    public String getDsmName() {
        return dsmName;
    }

    public void setDsmName(String dsmName) {
        this.dsmName = dsmName;
    }


    public ReportTsmDetails(String dsmName, String customerMet, String pending, String sold, String lost, String dsmId) {
        this.dsmName = dsmName;
        this.customerMet = customerMet;
        this.pending = pending;
        this.sold = sold;
        this.lost = lost;
        this.dsmId = dsmId;
    }
}
