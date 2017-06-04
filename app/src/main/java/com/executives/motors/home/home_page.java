package com.executives.motors.home;

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
import android.widget.Toast;

import com.executives.motors.R;
import com.executives.motors.change_password.view.ChangePassFragment;
import com.executives.motors.employee.view.EmployeeFragment;
import com.executives.motors.helper.SharedPrefs;
import com.executives.motors.profile.view.ProfileFragment;
import com.executives.motors.splash_screen.view.SplashScreenActivity;
import com.executives.motors.targets.view.TargetFragment;

public class home_page extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private  SharedPrefs sharedPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPrefs = new SharedPrefs(this);
        Log.d("UserHome",sharedPrefs.getUserType()+"");
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
//        setFragment(new ProfileFragment(),"Profile");
//        getSupportActionBar().setTitle("Tata Motors");
        sharedPrefs.setKeyEmployeeType(sharedPrefs.getUserType());
        ProfileFragment profileFragment=ProfileFragment.newInstance(sharedPrefs.getUserId());
        Log.d("drawer",sharedPrefs.getUserId()+" ");
        setFragment(profileFragment,"Profile");
        Toast.makeText(this,"Complete Your Profile",Toast.LENGTH_SHORT).show();

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
//        if (id == R.id.action_settings) {
//            return true;
//        }

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
            sharedPrefs.setKeyEmployeeType(sharedPrefs.getUserType());
            ProfileFragment profileFragment=ProfileFragment.newInstance(sharedPrefs.getUserId());
            Log.d("drawer",sharedPrefs.getUserId()+" ");
            setFragment(profileFragment,"Profile");
        } else if (id == R.id.nav_customer) {
            sharedPrefs.setKeyEmployeeType(sharedPrefs.getUserType());
//            setFragment(new AddCustomerFragment(),"Add Customer");

            if(sharedPrefs.getUserType().equals("0"))
            {
                EmployeeFragment customer_fragment=EmployeeFragment.newInstance("4",-1);
                setFragment(customer_fragment, "Customers");
            }
            else if(sharedPrefs.getUserType().equals("1"))
            {
                EmployeeFragment customer_fragment=EmployeeFragment.newInstance("4",-1);
                setFragment(customer_fragment, "Customers");
            }
            else if(sharedPrefs.getUserType().equals("2"))
            {
                EmployeeFragment customer_fragment=EmployeeFragment.newInstance("4",sharedPrefs.getUserId());
                setFragment(customer_fragment, "Customers");
            }

        } else if (id == R.id.nav_dsm) {

            EmployeeFragment fragment = EmployeeFragment.newInstance("1",-1);
            setFragment(fragment ,"DSM");

        }else if (id == R.id.nav_dse) {

            if(sharedPrefs.getUserType().equals("0"))
            {
                EmployeeFragment fragment = EmployeeFragment.newInstance("2",-1);
                setFragment(fragment,"DSE");
            }
            else if(sharedPrefs.getUserType().equals("1"))
            {
                EmployeeFragment fragment = EmployeeFragment.newInstance("2",sharedPrefs.getUserId());
                setFragment(fragment,"DSE");
            }


        }else if (id == R.id.nav_dealer) {

            EmployeeFragment fragment = EmployeeFragment.newInstance("3",-1);
            setFragment(fragment,"Dealers");

        }

        else if (id == R.id.nav_targets) {
            sharedPrefs.setKeyEmployeeType(sharedPrefs.getUserType());
            setFragment(new TargetFragment(), "Targets");
        }
        else if (id == R.id.nav_pass) {
            sharedPrefs.setKeyEmployeeType(sharedPrefs.getUserType());
            setFragment(new ChangePassFragment(), "Change Password");
//            setFragment(new ReportFragment(),"Reports");
        }
        else if (id == R.id.nav_report) {
            sharedPrefs.setKeyEmployeeType(sharedPrefs.getUserType());
            EmployeeFragment fragment = EmployeeFragment.newInstance("4",sharedPrefs.getUserId());
            setFragment(fragment,"Customers");
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
