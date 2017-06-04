package com.executives.motors.login.view;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
//import android.support.multidex.MultiDex;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.executives.motors.R;
import com.executives.motors.helper.SharedPrefs;
import com.executives.motors.home.home_page;
import com.executives.motors.login.models.RetrofitLoginScreenProvider;
import com.executives.motors.login.models.data.LoginData;
import com.executives.motors.login.presenter.LoginScreenPresenter;
import com.executives.motors.login.presenter.LoginScreenPresenterImpl;
import com.executives.motors.welcome_screen.view.WelcomeScreenActivity;


import butterknife.ButterKnife;

/**
 * Created by aman on 15/10/16.
 */
public class LoginScreenActivity extends Activity implements LoginScreenView {


    String name1;
    EditText name;
    Button login_button;
    EditText password;
    String password1;

    private SharedPrefs sharedPrefs;
    private ProgressBar progressbar;

    private RetrofitLoginScreenProvider retrofitLoginScreenProvider;
    private LoginScreenPresenter loginScreenPresenter;

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
//        MultiDex.install(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_loginscreen);

//        ButterKnife.bind(this);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
        //progressbar = (ProgressBar)findViewById(R.id.barLogin);
        Log.d("Response", "1");
        sharedPrefs = new SharedPrefs(this);
        progressbar = (ProgressBar) findViewById(R.id.barLogin);
        Log.d("Response", "2");

        login_button = (Button) findViewById(R.id.button);
        name = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        Log.d("Response", "3");


        ButterKnife.bind(this);
        Log.d("Response", "4");

//        loginScreenPresenter = new LoginScreenPresenterImpl(this, new MockLoginProvider());
        loginScreenPresenter = new LoginScreenPresenterImpl(this, new RetrofitLoginScreenProvider());

        Log.d("Response", "5");
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name1 = name.getText().toString();
                password1 = password.getText().toString();

//                sharedPrefs.setUserType("0");
//                sharedPrefs.setAccessToken("A0123");
//                sharedPrefs.setUserId("Danny");
//                sharedPrefs.setKeyEmployeeType("1");

                Log.d("Response", "b1");
                if (name1.equals("") || name1.equals(null)) {

                    name.setError("Please fill name");
                    name.requestFocus();
                } else if (password1.equals("") || password1.equals(null)) {
                    password.setError("Please fill password");
                    password.requestFocus();

                }

                if ((name1.equals("") || name1.equals(null)) ||
                        ((password1.equals("") || password1.equals(null))  )
                        )

                {
                } else {
                    login_button.setEnabled(false);
                    loginScreenPresenter.requestLogin(name1,password1);
                }


                Log.d("login", "oncreate_1");
            }
        });
        Log.d("login", "oncreate_2");


    }

    @Override
    public void showLoading(boolean show) {
        if (show) {
            progressbar.setVisibility(View.VISIBLE);
        } else {
            progressbar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }

     @Override
    public void onLoginVerified(LoginData loginData) {

         sharedPrefs.setUserType(loginData.getUser_type());
         sharedPrefs.setAccessToken(loginData.getAccess_token());
         sharedPrefs.setUserId(loginData.getUser_id());
         Log.d("login",sharedPrefs.getUserId()+" ");
         sharedPrefs.setKeyEmployeeType(loginData.getUser_type());//equals to UserType
         sharedPrefs.setLogin(true);

        Intent in = new Intent(LoginScreenActivity.this, home_page.class);
        startActivity(in);
        finish();
    }

    @Override
    public void enableSubmit() {
        login_button.setEnabled(true);
    }

    @Override
    public void onBackPressed() {
        //    super.onBackPressed();
        Intent intent = new Intent(LoginScreenActivity.this, WelcomeScreenActivity.class);
        startActivity(intent);
        finish();

    }
}