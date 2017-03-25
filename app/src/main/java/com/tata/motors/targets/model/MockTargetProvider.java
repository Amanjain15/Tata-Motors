package com.tata.motors.targets.model;

import android.os.Handler;

import com.tata.motors.targets.SetTargetCallBack;
import com.tata.motors.targets.TargetCallBack;
import com.tata.motors.targets.model.data.TargetData;
import com.tata.motors.targets.model.data.TargetDataTsm;
import com.tata.motors.targets.model.data.TargetListDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 6/3/17.
 */

public class MockTargetProvider implements TargetProvider {


    @Override
    public void requestTarget(String user_id, String username, final TargetCallBack targetCallBack) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                targetCallBack.onSuccess(getMockTargetData());
            }
        },500);


    }

    @Override
    public void requestSetTarget(String user_id, String username,final SetTargetCallBack setTargetCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                setTargetCallBack.onSuccess(getMockSetTargetData());
            }
        },500);
    }


    public TargetData getMockTargetData(){

        TargetData targetData = new TargetData(true,"Data Received","10","30");

        return targetData;

    }

    public TargetDataTsm getMockSetTargetData(){

        List <TargetListDetails> targetListDetailses = new ArrayList<>();

        for(int i=0;i<5;i++)
        {
            TargetListDetails targetListDetails = new TargetListDetails("1","DSM","10","30");
            targetListDetailses.add(targetListDetails);
        }

        TargetDataTsm targetDataTsm = new TargetDataTsm(true,"List Received",targetListDetailses);
        return targetDataTsm;

    }
}
