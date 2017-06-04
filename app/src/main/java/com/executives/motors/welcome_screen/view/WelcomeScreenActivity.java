package com.executives.motors.welcome_screen.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.executives.motors.R;

import com.executives.motors.login.view.LoginScreenActivity;
import com.executives.motors.welcome_screen.model.RetrofitWelcomeScreenProvider;
import com.executives.motors.welcome_screen.model.data.WelcomeImageDetails;
import com.executives.motors.welcome_screen.presenter.WelcomeScreenPresenter;
import com.executives.motors.welcome_screen.presenter.WelcomeScreenPresenterImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by aman on 14/12/16.
 */

public class WelcomeScreenActivity extends AppCompatActivity implements WelcomeScreenView {

    private ViewPager viewPager;
    private ProgressBar progressBar;
    private ViewPagerAdapter viewPagerAdapter;
    private WelcomeScreenPresenter welcomeScreenPresenter;
    private Button button,button_next ;
    List<WelcomeImageDetails> welcomeImageDetailses = new ArrayList<>();
    Timer timer;
    int page=1;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        button = (Button)findViewById(R.id.button_login);
        button_next = (Button)findViewById(R.id.button_next);
        initialise();

        if(viewPager.getCurrentItem()==welcomeImageDetailses.size())
        {
            button_next.setVisibility(View.GONE);
            button.setVisibility(View.VISIBLE);

        }
    }

    public void initialise() {

        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager =new ViewPager(this);
        welcomeScreenPresenter = new WelcomeScreenPresenterImpl(this, new RetrofitWelcomeScreenProvider());
        welcomeScreenPresenter.getWelcomeData();
        viewPagerAdapter= new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);


    }

    public void button(View v) {
        Intent i = new Intent(WelcomeScreenActivity.this, LoginScreenActivity.class); //activity yet to be made
        startActivity(i);
        finish();
    }
    public void button_next(View v) {
        viewPager.arrowScroll(View.FOCUS_LEFT);
    }

    @Override
    public void showMessage(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressBar(boolean show) {
        if(show){
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setData(List<WelcomeImageDetails> welcomeImageDetails) {
        welcomeImageDetailses = welcomeImageDetails;

        viewPagerAdapter.setImageList(welcomeImageDetails);
        viewPagerAdapter.notifyDataSetChanged();
        pageSwitcher(3);
    }

    public void pageSwitcher(int seconds) {
        timer = new Timer();// At this line a new Thread will be created
        timer.scheduleAtFixedRate(new RemindTask(), 0 , seconds * 1000); //delay
    }

    class RemindTask extends TimerTask{

        @Override
        public void run() {

            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            runOnUiThread(new Runnable() {
                public void run() {

                    if (page > 3) { // In my case the number of pages are 5
                        timer.cancel();
                        // Showing a toast for just testing purpose
/*
                        Toast.makeText(getApplicationContext(), "Timer stoped",
                                Toast.LENGTH_LONG).show();
*/
                    } else {
                        viewPager.setCurrentItem(page++);
                    }
                }
            });

        }

    }
}
