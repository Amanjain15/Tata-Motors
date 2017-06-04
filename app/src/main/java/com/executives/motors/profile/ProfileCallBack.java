package com.executives.motors.profile;

import com.executives.motors.profile.model.data.ProfileData;

/**
 * Created by aman on 25/1/17.
 */
public interface ProfileCallBack {
    void onFailure();
    void OnSuccess(ProfileData profileData);
}
