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
import com.tata.motors.employee.model.MockEmployee;
import com.tata.motors.employee.model.data.EmployeeData;
import com.tata.motors.employee.model.data.EmployeeListDetails;
import com.tata.motors.employee.presenter.EmployeePresenter;
import com.tata.motors.employee.presenter.EmployeePresenterImpl;
import com.tata.motors.helper.SharedPrefs;
import com.tata.motors.home.home_page;
import com.tata.motors.profile.view.ProfileFragment;
import com.tata.motors.view_customer.view.ViewCustomerFragment;

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
    private SharedPrefs sharedPrefs;
    private EmployeePresenter presenter;

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
        sharedPrefs = new SharedPrefs(context);
        presenter = new EmployeePresenterImpl(new MockEmployee(),employeeView);

        holder.employeeName.setText(employeeListDetails.getUsername());

        switch (user_c_type)
        {
            case "1":
                holder.label1.setVisibility(View.VISIBLE);
                holder.label2.setVisibility(View.VISIBLE);
                holder.label3.setVisibility(View.VISIBLE);
                holder.label4.setVisibility(View.VISIBLE);
                holder.customer_met.setVisibility(View.VISIBLE);
                holder.lost.setVisibility(View.VISIBLE);
                holder.sold.setVisibility(View.VISIBLE);
                holder.pending.setVisibility(View.VISIBLE);
                holder.target.setVisibility(View.VISIBLE);
                holder.customer_met.setText(employeeListDetails.getCustomer_met()+"");
                holder.lost.setText(employeeListDetails.getLost()+"");
                holder.sold.setText(employeeListDetails.getSold()+"");
                holder.pending.setText(employeeListDetails.getPending()+"");
                holder.target.setText(employeeListDetails.getDaily_target()+"");
                break;
            case "2":
                holder.label1.setVisibility(View.VISIBLE);
                holder.label2.setVisibility(View.VISIBLE);
                holder.label3.setVisibility(View.VISIBLE);
                holder.label4.setVisibility(View.VISIBLE);
                holder.label5.setVisibility(View.VISIBLE);
                holder.customer_met.setVisibility(View.VISIBLE);
                holder.lost.setVisibility(View.VISIBLE);
                holder.sold.setVisibility(View.VISIBLE);
                holder.pending.setVisibility(View.VISIBLE);
                holder.target.setVisibility(View.VISIBLE);
                holder.customer_met.setText(employeeListDetails.getCustomer_met()+"");
                holder.lost.setText(employeeListDetails.getLost()+"");
                holder.sold.setText(employeeListDetails.getSold()+"");
                holder.pending.setText(employeeListDetails.getPending()+"");
                holder.target.setText(employeeListDetails.getDaily_target()+"");

                if(employeeListDetails.getColor_flag()==1)
                {
                    holder.safeButton.setVisibility(View.VISIBLE);
                    holder.linearLayout.setBackgroundColor(233150122);
                }

                holder.safeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        employeeView.safe(employeeListDetails.getUser_id());
//                        presenter.sendStatus(sharedPrefs.getAccessToken(),employeeListDetails.getUser_id());
                        employeeFragment.safe(employeeListDetails.getUser_id());
                    }
                });
                break;
            case "3":
                    holder.pro_button.setVisibility(View.INVISIBLE);
                break;
            case "4":

                break;

        }

        holder.customer_met.setText(employeeListDetails.getCustomer_met()+"");
        holder.lost.setText(employeeListDetails.getLost()+"");
        holder.sold.setText(employeeListDetails.getSold()+"");
        holder.pending.setText(employeeListDetails.getPending()+"");
//        if(user_c_type.equals("4"))
//            holder.emp_button.setVisibility(View.INVISIBLE);

        holder.pro_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProfileFragment profileFragment=ProfileFragment.newInstance(employeeListDetails.getUserId()); //UserID not ID
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

                        ViewCustomerFragment viewCustomerFragment= ViewCustomerFragment.newInstance(employeeListDetails.getUser_id());
                        ((home_page)context).setFragment(viewCustomerFragment,"Customer");
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

        private TextView employeeName,sold,lost,pending,customer_met,label1,label2,label3,label4,label5,target;
        private Button emp_button,pro_button,safeButton;
        private LinearLayout linearLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            employeeName=(TextView)itemView.findViewById(R.id.employee);
            pro_button=(Button)itemView.findViewById(R.id.view_profile);
            emp_button=(Button)itemView.findViewById(R.id.view_employee);
            sold=(TextView)itemView.findViewById(R.id.sold);
            lost=(TextView)itemView.findViewById(R.id.lost);
            pending=(TextView)itemView.findViewById(R.id.pending);
            target=(TextView)itemView.findViewById(R.id.target);
            customer_met=(TextView)itemView.findViewById(R.id.customerMet);
            safeButton=(Button)itemView.findViewById(R.id.button_safe);
            label1=(TextView)itemView.findViewById(R.id.label_lost);
            label2=(TextView)itemView.findViewById(R.id.label_pending);
            label3=(TextView)itemView.findViewById(R.id.label_cust);
            label4=(TextView)itemView.findViewById(R.id.label_sold);
            label5=(TextView)itemView.findViewById(R.id.label_target);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.layout);




        }
    }
}
