package com.tata.motors.add_customer.view;

import com.tata.motors.add_customer.model.data.AddCustomerData;
import com.tata.motors.add_customer.model.data.ApplicationListDetails;
import com.tata.motors.add_customer.model.data.DistrictListDetails;
import com.tata.motors.add_customer.model.data.DseListDetails;
import com.tata.motors.add_customer.model.data.DsmListDetails;
import com.tata.motors.add_customer.model.data.FinancierListDetails;
import com.tata.motors.add_customer.model.data.ModelListDetails;
import com.tata.motors.add_customer.model.data.TownListDetails;
import com.tata.motors.add_customer.model.data.VehicleListDetails;

import java.util.List;

/**
 * Created by aman on 27/1/17.
 */

public interface AddCustomerView {

    void showAdd();
    void showUpdate();
    void showProgressBar(boolean show);
    void showError(String error);
    //List-Spinners
    void showSpinners(AddCustomerData addCustomerData);
    void showSpinnerDsm(AddCustomerData addCustomerData);
    int showSpinnerApplication(AddCustomerData addCustomerData);
    int showSpinnerDistrict(AddCustomerData addCustomerData);
    int showSpinnerTown(AddCustomerData addCustomerData);
//    int showSpinnerModel(AddCustomerData addCustomerData);
//    int showSpinnerVehicle(AddCustomerData addCustomerData);
    int showSpinnerFinancier(AddCustomerData addCustomerData);
    void setValues(int i,String vehicle,String model,int quantity);

    void notifyChange(int itemCount);
    void intent();
//    void notifyChange(int i);
}
