package com.executives.motors.employee.model;

/**
 * Created by aman on 24/3/17.
 */

import android.os.Handler;
import android.util.Log;

import com.executives.motors.employee.EmployeeCallBack;
import com.executives.motors.employee.SendStatusCallBack;
import com.executives.motors.employee.model.data.EmployeeData;
import com.executives.motors.employee.model.data.EmployeeListDetails;
import com.executives.motors.employee.model.data.StatusData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 24/3/17.
 */
public class MockEmployee implements EmployeeProvider{


    @Override
    public void requestEmployee(String token, int choose_id,String user_c_type,String to_date,
                                String from_date,int choice,final EmployeeCallBack employeeCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                employeeCallBack.onSuccess(getMockEmployee());
                Log.d("Mock","1");


            }
        },500);
    }

    @Override
    public void sendStatus(String access_token, final int id, final SendStatusCallBack sendStatusCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                sendStatusCallBack.onSuccess(getMockStatusData(id));
                Log.d("Mock","1");


            }
        },500);
    }

    EmployeeData getMockEmployee(){

        List<EmployeeListDetails> employeeListDetailses = new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            EmployeeListDetails employeeListDetails = new EmployeeListDetails("a5y",1,1,1,1,i%2,i,1,1,1,1);
            employeeListDetailses.add(employeeListDetails);

        }

        EmployeeData employeeData = new EmployeeData(true,"Success",employeeListDetailses);
        return employeeData;
    }

    StatusData getMockStatusData(int id){
        Log.d("MockEmployee",id+"");
        return  new StatusData("Success",true,1);
    }

}
