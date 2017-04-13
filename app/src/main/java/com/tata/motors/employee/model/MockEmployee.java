package com.tata.motors.employee.model;

/**
 * Created by aman on 24/3/17.
 */

import android.os.Handler;
import android.util.Log;

import com.tata.motors.add_customer.model.data.ApplicationListDetails;
import com.tata.motors.add_customer.model.data.DistrictListDetails;
import com.tata.motors.add_customer.model.data.DseListDetails;
import com.tata.motors.add_customer.model.data.DsmListDetails;
import com.tata.motors.add_customer.model.data.FinancierListDetails;
import com.tata.motors.add_customer.model.data.ModelListDetails;
import com.tata.motors.add_customer.model.data.TownListDetails;
import com.tata.motors.add_customer.model.data.VehicleListDetails;
import com.tata.motors.employee.EmployeeCallBack;
import com.tata.motors.employee.model.data.EmployeeData;
import com.tata.motors.employee.model.data.EmployeeListDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 24/3/17.
 */
public class MockEmployee implements EmployeeProvider{


    @Override
    public void requestEmployee(String token, int choose_id,String user_c_type,final EmployeeCallBack employeeCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                employeeCallBack.onSuccess(getMockEmployee());
                Log.d("Mock","1");


            }
        },500);
    }

    EmployeeData getMockEmployee(){

        List<EmployeeListDetails> employeeListDetailses = new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            EmployeeListDetails employeeListDetails = new EmployeeListDetails(i,"Klieve Yorkin");
            employeeListDetailses.add(employeeListDetails);

        }

        EmployeeData employeeData = new EmployeeData(true,"Success",employeeListDetailses);
        return employeeData;
    }
}
