package com.executives.motors.report.model.data;

import java.util.List;

/**
 * Created by aman on 10/4/17.
 */

public class ReportDseData {

    private boolean success;
    private  String message;

   List<ReportDseDetails>dse_list;

    public ReportDseData(boolean success, String message, List<ReportDseDetails> dse_list) {
        this.success = success;
        this.message = message;
        this.dse_list = dse_list;
    }


    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<ReportDseDetails> getDse_list() {
        return dse_list;
    }
}
