package com.tata.motors.add_customer.view;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.tata.motors.R;
import com.tata.motors.add_customer.model.data.AddCustomerData;
import com.tata.motors.add_customer.model.data.ApplicationListDetails;
import com.tata.motors.add_customer.model.data.ModelListDetails;
import com.tata.motors.add_customer.model.data.VehicleListDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 9/4/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<ApplicationListDetails> applicationListDetailses = new ArrayList<>();
    private List<VehicleListDetails> vehicleListDetailses = new ArrayList<>();
    private AddCustomerData addCustomerData;
    private Context context;
    private AddCustomerView addCustomerView;
    private AddCustomerFragment addCustomerFragment;
    private LayoutInflater layoutInflater;
    private int itemCount=1;

    private ModelListDetails modelListDetails;
    private VehicleListDetails vehicleListDetails;
    private String model,vehicle;
    private int quantity;

    public RecyclerAdapter(Context context,AddCustomerFragment addCustomerFragment) {
        this.context = context;
        this.addCustomerView = new AddCustomerFragment();
        this.addCustomerFragment = addCustomerFragment;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setData(AddCustomerData addCustomerData) {
        this.addCustomerData = addCustomerData;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.add_customer_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.showSpinnerModel(addCustomerData);
        holder.showSpinnerVehicle(addCustomerData);
        quantity=Integer.parseInt(holder.quantity_tv.getText().toString());
        addCustomerView.setValues(position,holder.showSpinnerVehicle(addCustomerData),
                holder.showSpinnerModel(addCustomerData),quantity);
        holder.fab_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemCount+=1;
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        Spinner model_spinner;
        Spinner vehicle_spinner;
        TextView quantity_tv;
        FloatingActionButton fab_customer;

        public MyViewHolder(View itemView) {
            super(itemView);
            model_spinner=(Spinner)itemView.findViewById(R.id.model_spinner);
            vehicle_spinner=(Spinner)itemView.findViewById(R.id.vehicle_spinner);
            quantity_tv=(TextView)itemView.findViewById(R.id.quantity);
            fab_customer = (FloatingActionButton)itemView.findViewById(R.id.fab_customer);
        }

        //Spinner Functions

        public String showSpinnerVehicle(AddCustomerData addCustomerData) {
            List<VehicleListDetails> vehicleListDetailsList = new ArrayList<VehicleListDetails>(addCustomerData.getVehicleListDetails());
            ArrayAdapter<String> adapter;
            int n= vehicleListDetailsList.size();
            final int vehicle_id_ar[] = new int[n];
            final String  vehicle_name_ar[] =  new String[n];
            int i=0;
            while(i<n)
            {
                vehicleListDetails = vehicleListDetailsList.get(i);
                vehicle_id_ar[i]= vehicleListDetails.getVehicle_id();
                vehicle_name_ar[i] =vehicleListDetails.getVehicle_name();
                i++;
            }
            adapter = new ArrayAdapter<String>(context,
                    android.R.layout.simple_spinner_item, vehicle_name_ar);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            vehicle_spinner.setAdapter(adapter);
            vehicle_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {
                    vehicle = vehicle_name_ar[t];
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            return vehicle;
        }
        //SpinnerModel
        public String showSpinnerModel(AddCustomerData addCustomerData) {
            List<ModelListDetails> modelListDetailsList = new ArrayList<ModelListDetails>(addCustomerData.getModelListDetails());
            ArrayAdapter<String> adapter;
            int n= modelListDetailsList.size();
            final int model_id_ar[] = new int [n];
            final String model_name_ar[] = new String [n];

            int i=0;
            while(i<n)
            {
                modelListDetails = modelListDetailsList.get(i);
                model_id_ar[i] = modelListDetails.getModel_id();
                model_name_ar[i] = modelListDetails.getModel_name();
                i++;
            }
            adapter = new ArrayAdapter<String>(context,
                    android.R.layout.simple_spinner_item, model_name_ar);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            model_spinner.setAdapter(adapter);

            model_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {
                    model=model_name_ar[t];
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            return model;

        }

    }




}
