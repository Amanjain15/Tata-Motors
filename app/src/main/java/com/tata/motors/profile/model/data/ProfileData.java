package com.tata.motors.profile.model.data;

/**
 * Created by aman on 25/1/17.
 */
public class ProfileData {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String name;
    private String mobile_no;
    private String contact_no;
    private String email;
    private String address;
    private String designation;
    private String dealer;
private boolean success;
    private String message;

    public ProfileData(String  userName, String name, String mobile_no, String contact_no, String email, String address, String designation, String dealer, boolean success, String message) {
        this.userName = userName;
        this.name = name;
        this.mobile_no = mobile_no;
        this.contact_no = contact_no;
        this.email = email;
        this.address = address;
        this.designation = designation;
        this.dealer = dealer;
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }


}
