package com.executives.motors.profile.model;

import com.executives.motors.profile.ProfileCallBack;
import com.executives.motors.profile.SendProfileCallBack;

/**
 * Created by aman on 25/1/17.
 */
public interface ProfileProvider {


public void requestProfile(String access_token,int user_id ,ProfileCallBack profileCallBack);
    public void requestSendProfile(String access_token,int user_id, String name, String mobile_no,  String email, String address,String designation,SendProfileCallBack sendProfileCallBack);



}
