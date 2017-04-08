package com.tata.motors.profile;

import com.tata.motors.profile.model.data.ProfileSendData;

/**
 * Created by aman on 26/1/17.
 */
public interface SendProfileCallBack {

    void onFailure();
    void onSuccess(ProfileSendData profileSendData);



}
