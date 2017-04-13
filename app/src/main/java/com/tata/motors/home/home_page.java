package com.tata.motors.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.tata.motors.R;
import com.tata.motors.add_customer.view.AddCustomerFragment;
import com.tata.motors.add_user.view.AddUserFragment;
import com.tata.motors.change_password.view.ChangePassFragment;
import com.tata.motors.employee.view.EmployeeFragment;
import com.tata.motors.helper.Keys;
import com.tata.motors.helper.SharedPrefs;
import com.tata.motors.login.view.LoginScreenActivity;
import com.tata.motors.profile.view.ProfileFragment;
import com.tata.motors.report_dsm.view.ReportFragment;
import com.tata.motors.report_dsm.view.Report_dsmFragment;
import com.tata.motors.report_tsm.view.ReportTsmFragment;
import com.tata.motors.splash_screen.view.SplashScreenActivity;
import com.tata.motors.targets.view.SetTargets;
import com.tata.motors.targets.view.TargetFragment;
import com.tata.motors.welcome_screen.view.WelcomeScreenActivity;

public class home_page extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private  SharedPrefs sharedPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPrefs = new SharedPrefs(this);
        switch (sharedPrefs.getUserType())
        {
            case "0":
                setContentView(R.layout.activity_home_page);
                break;
            case "1":
                setContentView(R.layout.activity_home_page_dsm);
                break;
            case "2":
                setContentView(R.layout.activity_home_page_dse);
                break;
            default:
                setContentView(R.layout.activity_home_page);
                break;
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Log.d("","HOME");
//        setFragment(new SetTargets(), "SetTargets");
        setFragment(new TargetFragment(),"Targets");

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        sharedPrefs = new SharedPrefs(this);
        if (id == R.id.nav_sign_out) {
            sharedPrefs.setUserType("");
            sharedPrefs.setAccessToken("");
            sharedPrefs.setUserId(0);
            sharedPrefs.setKeyEmployeeType("");//equals to UserType
            sharedPrefs.setLogin(false);
            Intent i =new Intent(home_page.this, SplashScreenActivity.class);
            startActivity(i);
            finish();

        } else if (id == R.id.nav_profile) {
            ProfileFragment profileFragment=ProfileFragment.newInstance(sharedPrefs.getUserId());
            Log.d("drawer",sharedPrefs.getUserId()+" ");
            setFragment(profileFragment,"Profile");
        } else if (id == R.id.nav_customer) {

            setFragment(new AddCustomerFragment(),"Add Customer");

        } else if (id == R.id.nav_dsm) {

            EmployeeFragment fragment = EmployeeFragment.newInstance("1",-1);
            setFragment(fragment ,"Add DSM");

        }else if (id == R.id.nav_dse) {

            EmployeeFragment fragment = EmployeeFragment.newInstance("2",-1);
            setFragment(fragment,"Add DSE");

        }else if (id == R.id.nav_dealer) {

            EmployeeFragment fragment = EmployeeFragment.newInstance("3",-1);
            setFragment(fragment,"Add DSE");

        }

        else if (id == R.id.nav_targets) {
            setFragment(new TargetFragment(), "Targets");
        }
        else if (id == R.id.nav_pass) {
//            setFragment(new ChangePassFragment(), "Change Password");
            setFragment(new ReportFragment(),"Reports");
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void setFragment(Fragment fragment, String title) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.home_layout, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(title);
        }
    }
    public void addFragment(Fragment fragment, String title) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.home_layout, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(title);
        }
    }
}
