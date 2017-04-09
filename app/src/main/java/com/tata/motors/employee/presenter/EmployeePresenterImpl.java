package com.tata.motors.employee.presenter;

import com.tata.motors.employee.EmployeeCallBack;
import com.tata.motors.employee.model.EmployeeProvider;
import com.tata.motors.employee.model.data.EmployeeData;
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
    public void requestEmployee(String token, int choose_id,String user_c_type) {
             employeeView.showProgressbar(true);

             employeeProvider.requestEmployee(token, choose_id,user_c_type, new EmployeeCallBack() {
                 @Override
                 public void onSuccess(EmployeeData employeeData) {
                     if(employeeData.isSuccess()){
                         employeeView.showProgressbar(false);
                         employeeView.dataReceived(employeeData.getEmployeeListDetails());
                 }
                     else{
                         employeeView.showProgressbar(false);
                         employeeView.showMessage(employeeData.getMessage());
                     }
                 }

                 @Override
                 public void onFailure() {
                    employeeView.showProgressbar(false);
                     employeeView.showMessage("unable to connect");
                 }
             });









    }
}
