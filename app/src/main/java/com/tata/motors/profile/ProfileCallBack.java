package com.tata.motors.profile;

import com.tata.motors.profile.model.data.ProfileData;
import com.tata.motors.profile.model.data.ProfileSendData;

/**
 * Created by aman on 25/1/17.
 */
public interface ProfileCallBack {
    void onFailure();
    void OnSuccess(ProfileData profileData);
}
