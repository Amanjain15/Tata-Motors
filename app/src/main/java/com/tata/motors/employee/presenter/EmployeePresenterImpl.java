package com.tata.motors.employee.presenter;

import android.util.Log;

import com.tata.motors.employee.EmployeeCallBack;
import com.tata.motors.employee.SendStatusCallBack;
import com.tata.motors.employee.model.EmployeeProvider;
import com.tata.motors.employee.model.data.EmployeeData;
import com.tata.motors.employee.model.data.StatusData;
import com.tata.motors.employee.view.EmployeeView;

/**
 * Created by aman on 24/1/17.
 */
    public class EmployeePresenterImpl implements EmployeePresenter
     {
         private EmployeeProvider employeeProvider;
         private EmployeeView employeeView;


         public EmployeePresenterImpl(EmployeeProvider employeeProvider, EmployeeView employeeView) {
             this.employeeProvider = employeeProvider;
             this.employeeView = employeeView;
         }

         @Override
    public void requestEmployee(String token, int choose_id,String user_c_type,String to_date,String from_date,int choice) {
             employeeView.showProgressbar(true);

             employeeProvider.requestEmployee(token, choose_id,user_c_type,to_date,from_date,choice,
                     new EmployeeCallBack() {
                 @Override
                 public void onSuccess(EmployeeData employeeData) {
                     if(employeeData.isSuccess()){
                         employeeView.showProgressbar(false);
                         employeeView.dataReceived(employeeData.getEmployeeListDetails());
                         employeeView.showMessage(employeeData.getMessage());
                 }
                     else{
                         employeeView.showProgressbar(false);
                         employeeView.showMessage(employeeData.getMessage());
                     }
                 }

                 @Override
                 public void onFailure() {
                        //Recycler View Refresh
                        employeeView.showProgressbar(false);
                        employeeView.showMessage("unable to connect");
                 }
             });

    }

         @Override
         public void sendStatus(String access_token, int id) {
             Log.d("safeCall","Reached Presenter");
             employeeView.showProgressbar(true);
             Log.d("safeCall","Reached Presenter2");
             employeeProvider.sendStatus(access_token, id, new SendStatusCallBack() {
                 @Override
                 public void onSuccess(StatusData statusData) {
                     if(statusData.isSuccess())
                     {
                         employeeView.showProgressbar(false);
                         employeeView.showMessage(statusData.getMessage());
                         Log.d("safeCall","Reached Success");
                     }
                     else {
                         employeeView.showProgressbar(false);
                         employeeView.showMessage(statusData.getMessage());
                         Log.d("safeCall","Reached Failure");
                     }
                 }

                 @Override
                 public void onFailure(String error) {
                         employeeView.showProgressbar(false);
                         employeeView.showMessage(error);
                     Log.d("safeCall","Reached Failure Of Callback");
                 }
             });

         }
     }
