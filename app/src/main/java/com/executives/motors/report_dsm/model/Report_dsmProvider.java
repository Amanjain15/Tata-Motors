package com.executives.motors.report_dsm.model;

import com.executives.motors.report_dsm.Report_dsmCallBack;
import com.executives.motors.report_dsm.SendStatusCallBack;

/**
 * Created by aman on 12/4/17.
 */

public interface Report_dsmProvider {

    void requestDsm(String access_token, int user_id,int type, Report_dsmCallBack report_dsmCallBack);
    void sendStatus(String access_token, int id, SendStatusCallBack sendStatusCallBack);
}
