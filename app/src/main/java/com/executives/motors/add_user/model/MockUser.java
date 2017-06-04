package com.executives.motors.add_user.model;

import android.os.Handler;
import android.util.Log;

import com.executives.motors.add_user.AddUserCallBack;
import com.executives.motors.add_user.model.data.AddUserData;
import com.executives.motors.add_user.model.data.DealerListDetails;
import com.executives.motors.add_user.model.data.DsmListDetails;

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
