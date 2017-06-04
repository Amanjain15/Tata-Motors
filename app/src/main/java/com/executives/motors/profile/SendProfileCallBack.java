package com.executives.motors.profile;

import com.executives.motors.profile.model.data.ProfileSendData;

/**
 * Created by aman on 26/1/17.
 */
public interface SendProfileCallBack {

    void onFailure();
    void onSuccess(ProfileSendData profileSendData);



}
