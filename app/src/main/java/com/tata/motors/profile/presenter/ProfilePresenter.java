package com.tata.motors.profile.presenter;

import com.tata.motors.profile.ProfileCallBack;

/**
 * Created by aman on 25/1/17.
 */
public interface ProfilePresenter {
    public void requestProfile(String access_token,String userId );
    public void requestSendProfile(String access_token,String userId,String userName,String name,String contactNo,String phoneNo,String address,String email,String post,String dealer);
}
