package com.executives.motors.profile.presenter;

import com.executives.motors.profile.ProfileCallBack;
import com.executives.motors.profile.SendProfileCallBack;
import com.executives.motors.profile.model.ProfileProvider;
import com.executives.motors.profile.model.data.ProfileData;
import com.executives.motors.profile.model.data.ProfileSendData;
import com.executives.motors.profile.view.ProfileView;

/**
 * Created by aman on 25/1/17.
 */
public class ProfilePresenterImpl implements ProfilePresenter{

    private ProfileView profileView;
    private ProfileProvider profileProvider;

    public ProfilePresenterImpl(ProfileView profileView, ProfileProvider profileProvider) {
        this.profileView = profileView;
        this.profileProvider = profileProvider;
    }


    @Override
    public void requestProfile(String access_token,int user_id) {
        profileView.showProgressBar(true);
        profileProvider.requestProfile(access_token,user_id, new ProfileCallBack() {
            @Override
            public void onFailure() {
                profileView.showProgressBar(false);
                profileView.showMessage("unable to connect");

            }

            @Override
            public void OnSuccess(ProfileData profileData) {
                if(profileData.isSuccess())
                {
                    profileView.showProgressBar(false);
                    profileView.onReceive(profileData);
                }
                else{
                    profileView.showProgressBar(false);
                    profileView.showMessage(profileData.getMessage());
                }

            }
        });



    }

    @Override
    public void requestSendProfile(String access_token,int user_id, String name, String mobileNo, String email, String address, String designation) {
        profileView.showProgressBar(true);
        profileProvider.requestSendProfile(access_token,  user_id, name, mobileNo, email, address, designation,  new SendProfileCallBack() {
            @Override
            public void onFailure() {
                profileView.buttonEnable(false,2);
                profileView.showProgressBar(false);
                profileView.showMessage("unable to connect");
            }

            @Override
            public void onSuccess(ProfileSendData profileSendData) {
                if(profileSendData.isSuccess())
                {
                    profileView.onSend(profileSendData);
                    profileView.showProgressBar(false);
                    profileView.disable_textview();
                    profileView.buttonEnable(true,1);
                    profileView.buttonEnable(false,2);

                }
                else{
                    profileView.buttonEnable(true,2); //visibility
                    profileView.buttonEnable(true,1); //enability
                    profileView.showProgressBar(false);
                    profileView.showMessage(profileSendData.getMessage());
                }

            }
        });





    }
}
