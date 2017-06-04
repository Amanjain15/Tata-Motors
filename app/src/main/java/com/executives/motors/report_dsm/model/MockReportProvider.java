package com.executives.motors.report_dsm.model;

import android.os.Handler;
import android.util.Log;

import com.executives.motors.report_dsm.Report_dsmCallBack;
import com.executives.motors.report_dsm.SendStatusCallBack;
import com.executives.motors.report_dsm.model.data.ReportDaily;
import com.executives.motors.report_dsm.model.data.ReportMonthly;
import com.executives.motors.report_dsm.model.data.Report_dsmData;
import com.executives.motors.report_dsm.model.data.StatusData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 12/4/17.
 */

public class MockReportProvider implements Report_dsmProvider{


    @Override
    public void requestDsm(String access_token, int dealer_id,int type,final Report_dsmCallBack report_dsmCallBack) {
        Log.d("mock","b");
        report_dsmCallBack.onSuccess(getMockRequest());

    }



    @Override
    public void sendStatus(String access_token, int id, final SendStatusCallBack sendStatusCallBack) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                sendStatusCallBack.onSuccess(getMockStatus());
            }


        },1000);
    }



    private Report_dsmData getMockRequest(){

        List<ReportDaily> reportDailyList=new ArrayList<>();
        List<ReportMonthly> reportMonthlyList=new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            ReportMonthly reportMonthly=new ReportMonthly(i,i+1,i+2,i+3,0,i+5,"aman");
            reportMonthlyList.add(reportMonthly);
            Log.d("mock",""+i);
            ReportDaily reportDaily=new ReportDaily(i,i+1,i+2,i+3,1,i+5,"amanag");
            reportDailyList.add(reportDaily);


        }

        Report_dsmData reportDsm=new Report_dsmData("Success",true,reportDailyList,reportMonthlyList);
        Log.d("mock",reportDailyList.size()+"");
        return  reportDsm;

    }

    private StatusData getMockStatus(){

        return new StatusData("Success",true);

    }


}
