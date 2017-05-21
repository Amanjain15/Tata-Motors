package com.tata.motors.employee.model.data;

/**
 * Created by aman on 24/1/17.
 */
public class EmployeeListDetails {

    private String name;
    private int lost, sold, customer_met,pending;
    private int color_flag,id,etu,ftu;                          //flag = 0 greeen, flag = 1 red
    private int daily_target,user_id;

    public EmployeeListDetails(String name, int lost, int sold, int customer_met, int pending,
                               int color_flag, int id, int etu, int ftu, int daily_target,
                               int user_id) {
        this.name = name;
        this.lost = lost;
        this.sold = sold;
        this.customer_met = customer_met;
        this.pending = pending;
        this.color_flag = color_flag;
        this.id = id;
        this.etu = etu;
        this.ftu = ftu;
        this.daily_target = daily_target;
        this.user_id=user_id;
    }

    public int getUserId() {
        return user_id;
    }

    public int getDaily_target() {
        return daily_target;
    }

    public int getUser_id() {
        return id;
    }
    public String getUsername() {
        return name;
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

    public int getColor_flag() {
        return color_flag;
    }

    public int getEtu() {
        return etu;
    }

    public int getFtu() {
        return ftu;
    }
}
