package com.executives.motors.report_dsm.presenter;

/**
 * Created by aman on 12/4/17.
 */

public interface Report_dsmPresenter {


    void requestDsm(String access_token, int user_id,int type);
        void sendStatus(String access_token,int id);
}
