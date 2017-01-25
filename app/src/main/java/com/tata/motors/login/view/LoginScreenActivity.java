package com.tata.motors.login.view;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tata.motors.R;
import com.tata.motors.helper.SharedPrefs;
import com.tata.motors.login.models.RetrofitLoginScreenProvider;
import com.tata.motors.login.presenter.LoginScreenPresenter;
import com.tata.motors.login.presenter.LoginScreenPresenterImpl;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
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


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private SharedPrefs sharedPrefs;
    private ProgressBar progressbar;
    private RetrofitLoginScreenProvider retrofitLoginScreenProvider;
    private LoginScreenPresenter loginScreenPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen);
        ButterKnife.bind(this);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Log.d("Response", "1");
        sharedPrefs = new SharedPrefs(this);
        progressbar = (ProgressBar) findViewById(R.id.progressBar);
        Log.d("Response", "2");

        login_button = (Button) findViewById(R.id.button);
        name = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        Log.d("Response", "3");


        ButterKnife.bind(this);
        Log.d("Response", "4");

        loginScreenPresenter = new LoginScreenPresenterImpl(this,
                new RetrofitLoginScreenProvider());

        Log.d("Response", "5");
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name1 = name.getText().toString();
                password1 = password.getText().toString();

                Log.d("Response", "b1");
                if (name1.equals("") || name1.equals(null)) {
                    name.setError("Please fill name");
                    name.requestFocus();
                } else if (password1.equals("") || password1.equals(null)) {
                    password.setError("Please fill mobile");
                    password.requestFocus();

                }

                if ((name1.equals("") || name1.equals(null)) ||
                        ((password1.equals("") || password1.equals(null))  )
                        )

                {


                } else {
                    loginScreenPresenter.requestLogin(name1,password1);
                }


                Log.d("Response", "b2");
            }
        });
        Log.d("Response", "6");


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

   /* @Override
    public void onLoginVerified() {
        Intent in = new Intent(LoginScreenActivity.this, OtpViewImpl.class);
        in.putExtra("mobile", mobile1);
        startActivity(in);
        finish();

    }

    @Override
    public void onBackPressed() {
        //    super.onBackPressed();
        Intent intent = new Intent(LoginScreenActivity.this, WelcomeScreenActivity.class);
        startActivity(intent);
        finish();

    } */
}