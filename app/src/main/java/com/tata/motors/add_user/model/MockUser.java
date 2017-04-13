package com.tata.motors.add_user.model;

import android.os.Handler;
import android.util.Log;

import com.tata.motors.add_customer.model.data.ApplicationListDetails;
import com.tata.motors.add_customer.model.data.DistrictListDetails;
import com.tata.motors.add_customer.model.data.DseListDetails;
import com.tata.motors.add_customer.model.data.FinancierListDetails;
import com.tata.motors.add_customer.model.data.ModelListDetails;
import com.tata.motors.add_customer.model.data.TownListDetails;
import com.tata.motors.add_customer.model.data.VehicleListDetails;
import com.tata.motors.add_user.AddUserCallBack;
import com.tata.motors.add_user.model.data.AddUserData;
import com.tata.motors.add_user.model.data.DealerListDetails;
import com.tata.motors.add_user.model.data.DsmListDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 24/3/17.
 */

public class MockUser implements AddUserProvider {
    @Override
    public void requestAddUser(String access_token,int user_id, String key_employee_type, final AddUserCallBack addUserCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                addUserCallBack.onSuccess(getMockAddUser());
                Log.d("Mock","1");


            }
        },500);
    }

  public AddUserData getMockAddUser(){

        List <DsmListDetails> dsmListDetailses = new ArrayList<>();
        List <DealerListDetails> dealerListDetailses = new ArrayList<>();

        for(int i=0;i<5;i++)
        {
            DsmListDetails dsmListDetails = new DsmListDetails(i,"Jack");
            dsmListDetailses.add(dsmListDetails);
            DealerListDetails dealerListDetails = new DealerListDetails(i,"Tata");
            dealerListDetailses.add(dealerListDetails);
        }

        AddUserData addUserData = new AddUserData(true,"Success",1,dsmListDetailses,dealerListDetailses);
        return addUserData;
    }
}
