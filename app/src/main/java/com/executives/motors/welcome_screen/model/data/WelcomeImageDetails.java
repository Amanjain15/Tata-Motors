package com.executives.motors.welcome_screen.model.data;

/**
 * Created by aman on 30/12/16.
 */

public class WelcomeImageDetails {

    private String image_id;
    private String image_url;
    private String message;


    public WelcomeImageDetails(String image_id, String image_url, String message) {
        this.image_id = image_id;
        this.image_url = image_url;
        this.message = message;
    }

    public String getImage_id() {
        return image_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getMessage() {
        return message;
    }
}
