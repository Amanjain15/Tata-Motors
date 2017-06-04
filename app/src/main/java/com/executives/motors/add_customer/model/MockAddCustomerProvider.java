package com.executives.motors.add_customer.model;

import android.os.Handler;
import android.util.Log;

import com.executives.motors.add_customer.AddCustomerCallback;
import com.executives.motors.add_customer.model.data.AddCustomerData;
import com.executives.motors.add_customer.model.data.ApplicationListDetails;
import com.executives.motors.add_customer.model.data.DistrictListDetails;
import com.executives.motors.add_customer.model.data.DseListDetails;
import com.executives.motors.add_customer.model.data.DsmListDetails;
import com.executives.motors.add_customer.model.data.FinancierListDetails;
import com.executives.motors.add_customer.model.data.ModelListDetails;
import com.executives.motors.add_customer.model.data.TownListDetails;
import com.executives.motors.add_customer.model.data.VehicleListDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 19/2/17.
 */

public class MockAddCustomerProvider implements AddCustomerProvider {
    @Override
    public void requestAddCustomer(String access_token, final AddCustomerCallback addCustomerCallback) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                addCustomerCallback.onSuccess(getMockAddCustomerDetails());
                Log.d("Mock","1");


            }
        },500);
    }

    private AddCustomerData getMockAddCustomerDetails()
    {

        List<ApplicationListDetails> applicationListDetailsList= new ArrayList<>();
        List<DistrictListDetails> districtListDetailsList= new ArrayList<>();
        List<TownListDetails> townListDetailsList= new ArrayList<>();
        List<FinancierListDetails> financierListDetailsList= new ArrayList<>();
        List<ModelListDetails> modelListDetailsList= new ArrayList<>();
        List<VehicleListDetails> vehicleListDetailsList= new ArrayList<>();
        List<DsmListDetails> dsmListDetailsList= new ArrayList<>();
        List<DseListDetails> dseListDetailsList= new ArrayList<>();

        for(int i=0;i<5;i++)
        {
            ApplicationListDetails applicationListDetails = new ApplicationListDetails(i,"Mahindra");
            applicationListDetailsList.add(applicationListDetails);
            DistrictListDetails districtListDetails = new DistrictListDetails(i,"Raipur");
            districtListDetailsList.add(districtListDetails);
            TownListDetails townListDetails = new TownListDetails(i,"Bilaspur");
            townListDetailsList.add(townListDetails);
            FinancierListDetails financierListDetails = new FinancierListDetails(i,"ICICI");
            financierListDetailsList.add(financierListDetails);
            ModelListDetails modelListDetails = new ModelListDetails(i,"A0123");
            modelListDetailsList.add(modelListDetails);
            VehicleListDetails vehicleListDetails = new VehicleListDetails(i,"SUV");
            vehicleListDetailsList.add(vehicleListDetails);
            DsmListDetails dsmListDetails = new DsmListDetails(i,"Jim Priestin");
            dsmListDetailsList.add(dsmListDetails);
            DseListDetails dseListDetails = new DseListDetails(i,"Klieve Yorkin");
            dseListDetailsList.add(dseListDetails);

        }

        AddCustomerData addCustomerData = new AddCustomerData(true,"List Received",0,
                applicationListDetailsList,districtListDetailsList,townListDetailsList,
                financierListDetailsList,modelListDetailsList,vehicleListDetailsList,
                dsmListDetailsList);


        return addCustomerData;
    }
}
