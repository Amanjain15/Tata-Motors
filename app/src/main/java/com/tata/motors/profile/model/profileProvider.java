package com.tata.motors.profile.model;

import com.tata.motors.profile.ProfileCallBack;
import com.tata.motors.profile.SendProfileCallBack;

/**
 * Created by aman on 25/1/17.
 */
public interface profileProvider {


public void requestProfile(String access_token,int userId ,ProfileCallBack profileCallBack);
    public void requestSendProfile(String access_token, int userId, String name, String contactNo, String phoneNo, String address, String email, SendProfileCallBack sendProfileCallBack);



}
