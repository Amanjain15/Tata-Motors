package com.tata.motors.set_achievement.view;

import com.tata.motors.set_achievement.model.data.SetAchiData;

/**
 * Created by aman on 9/4/17.
 */

public interface SetAchiView {
void onSend();
    void showProgreebar(boolean show);
    void showLoading(boolean show);
    void showMessage(String message);
    void onVerified(SetAchiData setAchiData);
}

