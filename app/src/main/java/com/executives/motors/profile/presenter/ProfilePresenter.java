package com.executives.motors.profile.presenter;

/**
 * Created by aman on 25/1/17.
 */
public interface ProfilePresenter {
    public void requestProfile(String access_token,int user_id );
    public void requestSendProfile(String access_token,int user_id,String name,String mobileNo,String email,String address,String designation);
}
