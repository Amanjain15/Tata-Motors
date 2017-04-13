package com.tata.motors.report_tsm.model.data;

/**
 * Created by aman on 8/3/17.
 */
public class ReportTsmDetails {
    private String type,name;
    private int id;

    public ReportTsmDetails(String type, String name, int id) {
        this.type = type;
        this.name = name;
        this.id = id;
    }


    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}