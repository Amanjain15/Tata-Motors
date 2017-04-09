package com.tata.motors.targets.model;

import android.os.Handler;
import android.support.v7.graphics.Target;

import com.tata.motors.targets.ResponseTargetCallBack;
import com.tata.motors.targets.SetTargetCallBack;
import com.tata.motors.targets.TargetCallBack;
import com.tata.motors.targets.model.data.TargetData;
import com.tata.motors.targets.model.data.TargetDataTsm;
import com.tata.motors.targets.model.data.TargetListDetails;
import com.tata.motors.targets.model.data.TargetResponseData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 6/3/17.
 */

public class MockTargetProvider implements TargetProvider {

    @Override
    public void requestTarget(String user_type, int user_id, String username,final TargetCallBack targetCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                targetCallBack.onSuccess(getMockTargetData());
            }
        },500);

    }

    @Override
    public void requestSetTarget(int user_id, String username,final SetTargetCallBack setTargetCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                setTargetCallBack.onSuccess(getMockSetTargetData());
            }
        },500);
    }

    @Override
    public void responseSetTarget(String access_token, int user_id, String username,
                                  String monthly, String daily,
                                  final ResponseTargetCallBack responseTargetCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                responseTargetCallBack.onSuccess(getMockResponseData());
            }
        },500);

    }


    public TargetData getMockTargetData(){

        TargetData targetData = new TargetData(true,"Data Received","2","60");
        return targetData;

    }

    public TargetDataTsm getMockSetTargetData(){

        List <TargetListDetails> targetListDetailses = new ArrayList<>();

        for(int i=0;i<5;i++)
        {
            TargetListDetails targetListDetails = new TargetListDetails(i,"DSM","30","1");
            targetListDetailses.add(targetListDetails);
        }

        TargetDataTsm targetDataTsm = new TargetDataTsm(true,"List Received",targetListDetailses);
        return targetDataTsm;

    }

    public TargetResponseData getMockResponseData(){
        TargetResponseData targetResponseData = new TargetResponseData(true,"Success");
        return  targetResponseData;
    }
}
