package com.tata.motors.report.model;

import com.tata.motors.report.model.data.Daily;
import com.tata.motors.report.model.data.Monthly;
import com.tata.motors.report.model.data.ReportData;
import com.tata.motors.report.view.OnReportReceived;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iket on 25/1/17.
 */

public class MockReportProvider implements ReportProvider {
    @Override
    public void getReport(String access_token, OnReportReceived onReportReceived) {

        List<Daily> dailyList=new ArrayList<>();
        Daily daily=new Daily("Iket",10,5,5,5);
        dailyList.add(daily);
        List<Monthly> monthlyList=new ArrayList<>();
        Monthly monthly=new Monthly("iket",10,5,5,5);
        monthlyList.add(monthly);

        ReportData reportData=new ReportData(monthlyList,dailyList,true,"");

        onReportReceived.onSuccess(reportData);


    }
}
