package com.executives.motors.add_customer.model.data;

/**
 * Created by aman on 29/1/17.
 */

public class FinancierListDetails {

    private int id;
    private String name;

    public FinancierListDetails(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
