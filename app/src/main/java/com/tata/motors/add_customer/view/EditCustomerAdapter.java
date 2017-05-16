package com.tata.motors.add_customer.view;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.tata.motors.R;
import com.tata.motors.add_customer.model.data.EditCustomerData;
import com.tata.motors.add_customer.model.data.ModelListDetails;
import com.tata.motors.add_customer.model.data.VehicleListDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 12/4/17.
 */

public class EditCustomerAdapter extends RecyclerView.Adapter<EditCustomerAdapter.MyViewHolder> {

        private EditCustomerData editCustomerData;
        private Context context;
        private EditCustomerView editCustomerView;
        private EditCustomerFragment editCustomerFragment;
        private LayoutInflater layoutInflater;
        private int itemCount=1;

        private ModelListDetails modelListDetails;
        private VehicleListDetails vehicleListDetails;
        private String model,vehicle;
        private int quantity;




//private String model_id1[] = new String[10],vehicle_id1[] = new String[10];
//private int quantity1[] = new int[10];

        public EditCustomerAdapter(Context context, EditCustomerFragment editCustomerFragment) {
                this.context = context;
                this.editCustomerView= new EditCustomerFragment();
                this.editCustomerFragment = editCustomerFragment;
                this.layoutInflater = LayoutInflater.from(context);
                }

        public void setData(int count,EditCustomerData editCustomerData) {
                this.editCustomerData = editCustomerData;
                this.itemCount = count;
                }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = layoutInflater.inflate(R.layout.add_customer_item,parent,false);
                return new MyViewHolder(view);
                }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {

        try
        {
        //            holder.showSpinnerModel(position,addCustomerData);
        //            holder.showSpinnerVehicle(position,addCustomerData);
                List<VehicleListDetails> vehicleListDetailsList = new ArrayList<VehicleListDetails>(editCustomerData.getVehicle_list());
                ArrayAdapter<String> adapter;
                int n= vehicleListDetailsList.size();
                final int vehicle_id_ar[] = new int[n];
                final String  vehicle_name_ar[] =  new String[n];
                int i=0;
                while(i<n)
                {
                vehicleListDetails = vehicleListDetailsList.get(i);
                vehicle_id_ar[i]= vehicleListDetails.getId();
                vehicle_name_ar[i] =vehicleListDetails.getName();
                i++;
                }
                adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item, vehicle_name_ar);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                holder.vehicle_spinner.setAdapter(adapter);
                holder.vehicle_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {
                vehicle = vehicle_name_ar[t];
        //                    Log.d("AddCustomerSetValues0",position+" "+vehicle+" "+model+" "+quantity);

                editCustomerView.setValues(position,editCustomerData.getVehicle_data_list().get(position)
                        .getId(),vehicle,model,quantity);

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

                }
                });


                List<ModelListDetails> modelListDetailsList = new ArrayList<ModelListDetails>(editCustomerData.getVehicle_model_list());
                int n2= modelListDetailsList.size();
                final int model_id_ar[] = new int [n];
                final String model_name_ar[] = new String [n];

                i=0;
                while(i<n2)
                {
                modelListDetails = modelListDetailsList.get(i);
                model_id_ar[i] = modelListDetails.getId();
                model_name_ar[i] = modelListDetails.getName();
                i++;
                }
                adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item, model_name_ar);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                holder.model_spinner.setAdapter(adapter);

                holder.model_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {
                model=model_name_ar[t];
                editCustomerView.setValues(position,editCustomerData.getVehicle_data_list().get(position)
                        .getId(),vehicle,model,quantity);

        //                    Log.d("AddCustomerSetValues1",position+" "+vehicle+" "+model+" "+quantity);
                }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

                }
                });

                }

                catch (NullPointerException e){
                e.printStackTrace();
                }


                try {

                        if(position<editCustomerData.getVehicle_data_list().size())
                        holder.quantity_tv.setText(editCustomerData.getVehicle_data_list().get(position).getQuantity()+"");
                }catch (NullPointerException e)
                {
                        e.printStackTrace();
                }
                holder.quantity_tv.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                }

                @Override
                public void afterTextChanged(Editable editable) {
                try{
                                quantity=Integer.parseInt(holder.quantity_tv.getText().toString());
                                Log.d("AddCustomerSetValues2",position+" "+vehicle+" "+model+" "+quantity);
                                editCustomerView.setValues(position,editCustomerData.getVehicle_data_list().get(position)
                                        .getId(),vehicle,model,quantity);
                                }
                catch (NumberFormatException e)
                     {
                                e.printStackTrace();
                     }
                }
                });
                                Log.d("AddCustomerSetValues3",position+" "+vehicle+" "+model+" "+quantity);



//                holder.fab_customer.setVisibility(View.GONE);
                holder.fab_customer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                itemCount = itemCount+1;
//                                editCustomerFragment.setData(itemCount);
                        }
                });

        }

        @Override
        public int getItemCount() {
                return itemCount;
                }

        @Override
        public long getItemId(int position) {
                return super.getItemId(position);
                }

        class MyViewHolder extends RecyclerView.ViewHolder {
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

        }

}
