package com.tata.motors.profile.presenter;

import com.tata.motors.profile.ProfileCallBack;
import com.tata.motors.profile.SendProfileCallBack;
import com.tata.motors.profile.model.ProfileProvider;
import com.tata.motors.profile.model.data.ProfileData;
import com.tata.motors.profile.model.data.ProfileSendData;
import com.tata.motors.profile.view.ProfileView;

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
    public void requestSendProfile(String access_token, String userName, String name, String mobileNo, String email, String address, String designation, String dealer) {
        profileView.showProgressBar(true);
        profileProvider.requestSendProfile(access_token, userName, name, mobileNo, email, address, designation, dealer, new SendProfileCallBack() {
            @Override
            public void onFailure() {
                profileView.showProgressBar(false);
                profileView.showMessage("unable to connect");
            }

            @Override
            public void onSuccess(ProfileSendData profileSendData) {
                if(profileSendData.isSuccess())
                {
                  profileView.onSend(profileSendData);
                    profileView.showProgressBar(false);

                }
                else{
                    profileView.showProgressBar(false);
                    profileView.showMessage(profileSendData.getMessage());
                }

            }
        });





    }
}
