package com.tata.motors.welcome_screen.model.data;

import java.util.List;

/**
 * Created by aman on 30/12/16.
 */

public class WelcomeScreenData {

    private boolean success;
    private List<WelcomeImageDetails> slider_data;
    private String message;

    public WelcomeScreenData(boolean success, List<WelcomeImageDetails> slider_data, String message) {
        this.success = success;
        this.slider_data = slider_data;
        this.message = message;
    }


    public boolean isSuccess() {
        return success;
    }

    public List<WelcomeImageDetails> getSlider_data() {
        return slider_data;
    }

    public String getMessage() {
        return message;
    }
}
