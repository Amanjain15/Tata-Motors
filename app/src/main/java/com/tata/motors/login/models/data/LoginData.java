package com.tata.motors.login.models.data;

/**
 * Created by aman on 15/10/16.
 */
public class LoginData {

    private String message;
    private boolean success;
    private String access_token;
    private String user_type;
    private String user_id;

    public LoginData(String message, boolean success, String access_token, String user_type, String user_id) {
        this.message = message;
        this.success = success;
        this.access_token = access_token;
        this.user_type = user_type;
        this.user_id = user_id;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getUser_type() {
        return user_type;
    }

    public String getUser_id() {
        return user_id;
    }
}
