package com.tata.motors.splash_screen.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tata.motors.R;

import com.tata.motors.BuildConfig;
import com.tata.motors.helper.SharedPrefs;
import com.tata.motors.splash_screen.model.MockSplash;
import com.tata.motors.splash_screen.model.RetrofitSplashScreenProvider;
import com.tata.motors.splash_screen.model.data.SplashScreenData;
import com.tata.motors.splash_screen.presenter.SplashScreenPresenter;
import com.tata.motors.splash_screen.presenter.SplashScreenPresenterImpl;
import com.tata.motors.welcome_screen.view.WelcomeScreenActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aman on 12/12/16.
 */

public class SplashScreenActivity extends Activity implements SplashScreenView {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.img)
    ImageView img;

    private SharedPrefs sharedPrefs;
    private SplashScreenPresenter splashScreenPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        sharedPrefs = new SharedPrefs(this);
        //splashScreenPresenter=new SplashScreenPresenterImpl(this, new RetrofitSplashScreenProvider());
        splashScreenPresenter=new SplashScreenPresenterImpl(this,
                new MockSplash());
        splashScreenPresenter.requestSplash();
    }




    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message,Toast.LENGTH_LONG).show();

    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void version_check(SplashScreenData splashScreenData) {


        int i=splashScreenData.getVersion();
        if(i > BuildConfig.VERSION_CODE)
        {
            final Dialog dialog=new Dialog(SplashScreenActivity.this);
            dialog.setContentView(R.layout.activity_splash_dialog);
            Button btn = (Button)dialog.findViewById(R.id.dialog_button);
            TextView text=(TextView)dialog.findViewById(R.id.dialog_textview);
            if(splashScreenData.getCompulsory_update() == 1){

                text.setText("Major Update is available");
                dialog.setCancelable(false);
            }
            else{
                text.setText("Update is Available");
                dialog.setCancelable(true);

            }

            dialog.setTitle("App Update");
            btn.setText("Update");
            dialog.show();
            btn.setOnClickListener(
                    new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {

                            final String appPackageName = getPackageName();
                            try {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse
                                        ("market://details?id="
                                                + appPackageName)));
                            } catch (android.content.ActivityNotFoundException e) {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(
                                        "https://play.google.com/store/apps/details?id=" + appPackageName)));
                            }


                        }
                    }

            );


        }
        else if (splashScreenData.isSuccess()){


                    if(sharedPrefs.isLoggedIn()){
                        Log.d("Res", "" + sharedPrefs.isLoggedIn());
           //           Intent home = new Intent(SplashScreenActivity.this, Homepage.class);
           //           startActivity(home);
            //          finish();

                    }
                    else
                    {
                        Log.d("Res", "" + sharedPrefs.isLoggedIn());

                        Intent welcome = new Intent(SplashScreenActivity.this, WelcomeScreenActivity.class);
                        startActivity(welcome);
                        finish();

                    }


                }




        }



}
