package com.tata.motors.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by aman on 12/12/16.
 */

public class SharedPrefs {
    private static final String PREF_NAME = "welcome";
    private static final String PREF_NAME_LOGIN = "Login";
    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_USER_ID ="0";
    private static final String KEY_LOGIN_TYPE = "loginType";
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final int KEY_VERSION = 1;
    private static final String KEY_EMPLOYEE_TYPE="employee";
    private static final String KEY_USER_TYPE = "user_type";
    private static final String KEY_PROFILE_EDIT = "profile_edit";

    // LogCat tag
    private static String TAG = "Shared Preference";

    // Shared Preferences
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    public SharedPrefs(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public static int getKeyVersion() {
        return KEY_VERSION;
    }

    public  String getKeyProfileEdit() {


        return pref.getString( KEY_PROFILE_EDIT, "0");
    }

    public void setKeyProfileEdit(String profile) {

        editor.putString(KEY_PROFILE_EDIT, profile);
        editor.commit();


    }






    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }

    public void setLogin(boolean isLoggedIn) {

        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);
        // commit changes
        editor.commit();
        Log.d(TAG, "User login session modified!");
    }

    public String getUsername() {
        return pref.getString(KEY_USERNAME, "Not Available");
    }

    public void setUsername(String username) {

        editor.putString(KEY_USERNAME, username);
        editor.commit();


    }


    public void setEmailId(String emailId) {

        editor.putString(KEY_EMAIL, emailId);
        editor.commit();

    }

    public int getUserId() {

        return pref.getInt(KEY_USER_ID, 0);
    }

    public void setUserId(int user_id) {

        editor.putInt(KEY_USER_ID, user_id);
        editor.commit();

    }

    public String getAccessToken() {

        return pref.getString(KEY_ACCESS_TOKEN, null);
    }

    public void setAccessToken(String accessToken) {
        editor.putString(KEY_ACCESS_TOKEN, accessToken);
        editor.commit();
    }

    public String getUserType() {
        return pref.getString(KEY_USER_TYPE, null);
    }
    public void setUserType(String userType) {
        editor.putString(KEY_USER_TYPE, userType);
        editor.commit();
    }


    public  String getKeyEmployeeType() {
        return pref.getString(KEY_EMPLOYEE_TYPE,null);
    }

    public void setKeyEmployeeType(String employee){
        editor.putString(KEY_EMPLOYEE_TYPE,employee);
        editor.commit();
    }



}
