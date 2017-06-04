package com.executives.motors.profile.model;

import android.os.Handler;
import android.util.Log;

import com.executives.motors.profile.ProfileCallBack;
import com.executives.motors.profile.SendProfileCallBack;
import com.executives.motors.profile.model.data.ProfileData;
import com.executives.motors.profile.model.data.ProfileSendData;

/**
 * Created by aman on 8/4/17.
 */

public class MockProfileProvider implements ProfileProvider {

    @Override
    public void requestProfile(String access_token,int user_id, final ProfileCallBack profileCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                profileCallBack.OnSuccess(getMockProfile());
                Log.d("Mock","1");


            }
        },500);
    }

    @Override
    public void requestSendProfile(String access_token, int user_id, String name, String mobile_no, String email, String address, String designation, final SendProfileCallBack sendProfileCallBack) {
        Log.d("Mock","1");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                sendProfileCallBack.onSuccess(getMockSendProfile());



            }
        },500);
    }


   ProfileData getMockProfile()
    {  ProfileData profileData=new ProfileData("aman","aman ag","987","@gmail","sadar","professor",true,"abcd","mgg");
      return(profileData);
    }

   ProfileSendData getMockSendProfile()
   {
       ProfileSendData profileSendData=new ProfileSendData(true,"vbhjv");
       return (profileSendData);

   }

}
