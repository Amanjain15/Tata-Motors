package com.executives.motors.login.models.data;

/**
 * Created by aman on 15/10/16.
 */
public class LoginData {

    private String message;
    private boolean success;
    private String access_token;
    private String user_type;
    private int user_id;
    private boolean change_password ;

    public LoginData(String message, boolean success, String access_token, String user_type, int user_id, boolean change_password) {
        this.message = message;
        this.success = success;
        this.access_token = access_token;
        this.user_type = user_type;
        this.user_id = user_id;
        this.change_password = change_password;
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

    public int getUser_id() {
        return user_id;
    }

    public boolean isChange_password() {
        return change_password;
    }
}
