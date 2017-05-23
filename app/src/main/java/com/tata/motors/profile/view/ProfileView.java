package com.tata.motors.profile.view;

import com.tata.motors.profile.model.data.ProfileData;
import com.tata.motors.profile.model.data.ProfileSendData;

/**
 * Created by aman on 25/1/17.
 */
public interface ProfileView {
    void showProgressBar(boolean show);
    void showMessage(String message);
    void onReceive(ProfileData profileData);
    void onSend(ProfileSendData profileSendData);
    public void disable_textview();
}
