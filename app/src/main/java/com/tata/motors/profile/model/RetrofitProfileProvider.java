package com.tata.motors.profile.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tata.motors.helper.Urls;
import com.tata.motors.profile.ProfileCallBack;
import com.tata.motors.profile.SendProfileCallBack;
import com.tata.motors.profile.api.ProfileApi;
import com.tata.motors.profile.api.ProfileSendApi;
import com.tata.motors.profile.model.data.ProfileData;
import com.tata.motors.profile.model.data.ProfileSendData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 25/1/17.
 */
public class RetrofitProfileProvider implements ProfileProvider {

    private ProfileApi profileApi;
    private ProfileSendApi profileSendApi;

    public RetrofitProfileProvider() {


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        profileApi = retrofit.create(ProfileApi.class);
        profileSendApi = retrofit.create(ProfileSendApi.class);

    }


    @Override
    public void requestProfile(String access_token,int user_id,  final ProfileCallBack profileCallBack) {
        Call<ProfileData> call = profileApi.requestProfile(access_token,user_id);
        call.enqueue(new Callback<ProfileData>() {
            @Override
            public void onResponse(Call<ProfileData> call, retrofit2.Response<ProfileData> response) {


                profileCallBack.OnSuccess(response.body());

            }

            @Override
            public void onFailure(Call<ProfileData> call, Throwable t) {
                profileCallBack.onFailure();
                t.printStackTrace();

            }
        });

    }

    @Override
    public void requestSendProfile(String access_token, String user_name, String name, String mobile_no, String email, String address, String designation, final SendProfileCallBack sendProfileCallBack) {
        Call<ProfileSendData>call=profileSendApi.requestSendData(access_token,user_name,name,mobile_no,email,address,designation);
        call.enqueue(new Callback<ProfileSendData>() {
            @Override
            public void onResponse(Call<ProfileSendData> call, retrofit2.Response<ProfileSendData> response) {
                sendProfileCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ProfileSendData> call, Throwable t) {
                           sendProfileCallBack.onFailure();
                t.printStackTrace();
            }
        });


    }
}
