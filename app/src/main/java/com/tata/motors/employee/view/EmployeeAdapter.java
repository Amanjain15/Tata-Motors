package com.tata.motors.employee.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tata.motors.R;
import com.tata.motors.add_user.view.AddUserFragment;
import com.tata.motors.employee.model.data.EmployeeData;
import com.tata.motors.employee.model.data.EmployeeListDetails;
import com.tata.motors.home.home_page;
import com.tata.motors.profile.view.ProfileFragment;

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
    private String user_c_type;

    public EmployeeAdapter(Context context,  EmployeeFragment employeeFragment) {
        this.context = context;
        this.employeeView = new EmployeeFragment();
        this.employeeFragment = employeeFragment;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setData(List<EmployeeListDetails> employeeListDetailses, String user_c_type) {
        detailsList = employeeListDetailses;
        this.user_c_type = user_c_type;
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

        if(user_c_type.equals("4"))
            holder.emp_button.setVisibility(View.INVISIBLE);

        holder.pro_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProfileFragment profileFragment=ProfileFragment.newInstance(employeeListDetails.getUser_id());
                ((home_page)context).setFragment(profileFragment,"PROFILE");

            }
        });

        holder.emp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (user_c_type)
                {
                    case "1":
                        EmployeeFragment dse_fragment=EmployeeFragment.newInstance("2",employeeListDetails.getUser_id());
                        ((home_page)context).setFragment(dse_fragment, "DSE");
                        break;
                    case "2":
                        EmployeeFragment customer_fragment=EmployeeFragment.newInstance("4",employeeListDetails.getUser_id());
                        ((home_page)context).setFragment(customer_fragment, "Customers");
                        break;
                    case "3":
                        EmployeeFragment dsm_fragment=EmployeeFragment.newInstance("1",employeeListDetails.getUser_id());
                        ((home_page)context).setFragment(dsm_fragment, "DSM");
                        break;
                    case "4":
                        //// TODO: 9/4/17 CustomerFragment to be made
                        break;

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView employeeName ;
        private Button emp_button,pro_button;
        public MyViewHolder(View itemView) {
            super(itemView);
            employeeName=(TextView)itemView.findViewById(R.id.employee);
            pro_button=(Button)itemView.findViewById(R.id.view_profile);
            emp_button=(Button)itemView.findViewById(R.id.view_employee);

        }
    }
}
