package com.executives.motors.view_customer.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.executives.motors.R;
import com.executives.motors.view_customer.model.data.VehicleDataList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 12/4/17.
 */

public class ViewCustomerAdapter extends RecyclerView.Adapter<ViewCustomerAdapter.MyViewHolder>{

    private Context context;
    private LayoutInflater layoutInflater;
    private ViewCustomerFragment viewCustomerFragment;
    private ViewCustomer viewCustomer;
    private VehicleDataList vehicleDatas;
    private List<VehicleDataList> vehicleDataLists=new ArrayList<>();


    public ViewCustomerAdapter(Context context,  ViewCustomerFragment viewCustomerFragment) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.viewCustomerFragment = viewCustomerFragment;
        this.viewCustomer = new ViewCustomerFragment();
    }

    public void setData(List<VehicleDataList> vehicleDataLists){
        this.vehicleDataLists = vehicleDataLists;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.view_customer_item,parent,false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        vehicleDatas=vehicleDataLists.get(position);
        try{
            holder.model1.setText(vehicleDatas.getVehicle_model_list());
            holder.vehicle1.setText(vehicleDatas.getVehicle_list());
            int q=vehicleDatas.getQuantity();
            holder.quantity1.setText(q+"");

        }catch (NullPointerException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return vehicleDataLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView vehicle1,quantity1,model1;
        public MyViewHolder(View itemView) {
            super(itemView);
            vehicle1=(TextView)itemView.findViewById(R.id.vehicle);
            model1=(TextView)itemView.findViewById(R.id.model);
            quantity1=(TextView)itemView.findViewById(R.id.quantity);
        }
    }
}
