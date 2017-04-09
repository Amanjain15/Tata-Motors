package com.tata.motors.profile.model.data;

/**
 * Created by aman on 25/1/17.
 */
public class ProfileData {
    private String user_name;
    private String name;
    private String mobile;
    private String email;
    private String address;
    private String designation;
   // private String dealer;
private boolean success;
    private String message;
    private String image;

    public ProfileData(String userName, String name, String mobile_no, String email, String address, String designation,
                       boolean success, String message, String image) {
        this.user_name = userName;
        this.name = name;
        this.mobile = mobile_no;
        this.email = email;
        this.address = address;
        this.designation = designation;

        this.success = success;
        this.message = message;
        this.image = image;
    }

    public String getUserName() {
        return user_name;
    }

    public String getName() {
        return name;
    }

    public String getMobile_no() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDesignation() {
        return designation;
    }


    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getImage() {
        return image;
    }
}
