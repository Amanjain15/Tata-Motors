package com.tata.motors.employee.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tata.motors.R;
import com.tata.motors.employee.model.data.EmployeeData;
import com.tata.motors.employee.model.data.EmployeeListDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 25/1/17.
 */
public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {
    private List<EmployeeListDetails> detailsList = new ArrayList<>();
    private Context context;
    private  EmployeeView employeeView;
    private EmployeeFragment employeeFragment;
    private LayoutInflater layoutInflater;

    public EmployeeAdapter(Context context,  EmployeeFragment employeeFragment) {
        this.context = context;
        this.employeeView = new EmployeeFragment();
        this.employeeFragment = employeeFragment;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setData(List<EmployeeListDetails> employeeListDetailses) {
        detailsList = employeeListDetailses;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.employee_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
final EmployeeListDetails employeeListDetails=detailsList.get(position);
holder.employeeName.setText(employeeListDetails.getUsername());
        holder.employeeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
      //          if (context instanceof HomePage) {
        //            ((HomePage) context).onEmployeeSelected(employeeListDetails.getUser_id(),employeeListDetails.getUsername());
          //      }
            }
        });



    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView employeeName ;
        public MyViewHolder(View itemView) {
            super(itemView);
            employeeName=(TextView)itemView.findViewById(R.id.employee);

        }
    }
}
