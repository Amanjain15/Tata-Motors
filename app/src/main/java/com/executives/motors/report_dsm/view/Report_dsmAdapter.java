package com.executives.motors.report_dsm.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.executives.motors.R;
import com.executives.motors.home.home_page;
import com.executives.motors.report_dsm.model.data.ReportDaily;
import com.executives.motors.report_dsm.model.data.ReportMonthly;
import com.executives.motors.report_dsm.model.data.Report_dsmData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 12/4/17.
 */

public class Report_dsmAdapter extends RecyclerView.Adapter<Report_dsmAdapter.MyViewHolder> {
    private List<ReportDaily> reportDetailsList = new ArrayList<>();
    private List<ReportMonthly> reportMonthlyList =new ArrayList<>();
    private Context context;
    int pos,type;
    private Report_dsmData report_dsmData;
    private Report_dsmFragment reports_dmFragment;
    private ViewPagerAdapter1 viewPagerAdapter;
    private LayoutInflater layoutInflater;
    private Report_dsmView report_dsmView;
    private int i;


    public Report_dsmAdapter(Context context,Report_dsmFragment report_dsmFragment) {
        this.context = context;
        this.report_dsmView = new Report_dsmFragment();
//        this.viewPagerAdapter=viewPagerAdapter;
        this.reports_dmFragment=report_dsmFragment;
        this.report_dsmView= new Report_dsmFragment();
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.report_dsm_item,parent,false);
        if(type==1)
        {
            view = layoutInflater.inflate(R.layout.report_dsm_item,parent,false);

        }else{
            view = layoutInflater.inflate(R.layout.report_dse_item,parent,false);
        }

        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        if (i == 0) {
            final ReportDaily reportDetails = reportDetailsList.get(position);
            Log.d("Recycler2", "type" + type + " " + reportDetailsList.size());
            if (type == 1) {
                holder.name.setText(reportDetails.getName());
                holder.customer_met.setText(reportDetails.getCustomer_met() + "");
                holder.sold.setText(reportDetails.getSold() + "");
                holder.pending.setText(reportDetails.getPending() + "");
                holder.lost.setText(reportDetails.getLost() + "");

                holder.button1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        ReportFragment reportFragment = ReportFragment.newInstance(reportDetails.getId(), 2);
                        ((home_page) context).setFragment(reportFragment, "DSE Report");
                    }
                });
            } else if(type==2){

                holder.name.setText(reportDetails.getName());
                holder.customer_met.setText(reportDetails.getCustomer_met() + "");
                holder.sold.setText(reportDetails.getSold() + "");
                holder.pending.setText(reportDetails.getPending() + "");
                holder.lost.setText(reportDetails.getLost() + "");
                holder.button1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        //// TODO: 12/4/17 BANANA HAI FRAGMENT
                    }
                });

                if (reportDetails.getFlag() == 0) {
                    holder.button.setVisibility(View.VISIBLE);
                    holder.linearLayout.setBackgroundColor(233150122);
                    holder.button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            holder.linearLayout.setBackgroundColor(255255255);
                            holder.button.setVisibility(View.GONE);
                            report_dsmView.statusCal(reportDetails.getId());

                        }
                    });

                }
            }
        }
        else if(i == 1){
            final ReportMonthly reportMonthly = reportMonthlyList.get(position);
            if (type == 1) {
                holder.name.setText(reportMonthly.getName());
                holder.customer_met.setText(reportMonthly.getCustomer_met() + "");
                holder.sold.setText(reportMonthly.getSold() + "");
                holder.pending.setText(reportMonthly.getPending() + "");
                holder.lost.setText(reportMonthly.getLost() + "");

                holder.button1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Log.d("ADAPTER",reportMonthly.getId()+"");
                        ReportFragment reportFragment = ReportFragment.newInstance(reportMonthly.getId(), 2);
                        ((home_page) context).setFragment(reportFragment, "DSE Report");
                    }
                });
            } else if(type==2){

                holder.name.setText(reportMonthly.getName());
                holder.customer_met.setText(reportMonthly.getCustomer_met() + "");
                holder.sold.setText(reportMonthly.getSold() + "");
                holder.pending.setText(reportMonthly.getPending() + "");
                holder.lost.setText(reportMonthly.getLost() + "");
                holder.button1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        //// TODO: 12/4/17 BANANA HAI FRAGMENT
                    }
                });

                if (reportMonthly.getFlag() == 0) {
                    holder.button.setVisibility(View.VISIBLE);
                    holder.linearLayout.setBackgroundColor(233150122);                 //set status daily 0 monthly 1
                    holder.button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            holder.linearLayout.setBackgroundColor(255255255);
                            holder.button.setVisibility(View.GONE);
                            report_dsmView.statusCal(reportMonthly.getId());

                        }
                    });

                }
            }




        }


    }

    public void setData(Report_dsmData report_dsmData, int a, int pos)
    {
        this.report_dsmData=report_dsmData;
        this.type=a;
        this.i=pos;
        if(i==0)
        {
            this.reportDetailsList=report_dsmData.getReportDailyList();
            Log.d("Recyclerdaily",reportDetailsList.size()+" "+reportDetailsList.size());
            Log.d("RecyclerDaily","type"+type+" "+reportDetailsList.size());
        }
        else if(i == 1){
            this.reportMonthlyList=report_dsmData.getReportMonthlyList();

        }
        Log.d("RecyclerMonth",reportMonthlyList.size()+" "+reportMonthlyList.size());
        Log.d("RecyclerMonth","type"+type+" "+reportMonthlyList.size());
    }

    @Override
    public int getItemCount() {
        int size=0;
        if(i==0) {
            size= reportDetailsList.size();
        }
        else if(i==1)
        {
             size = reportMonthlyList.size();
        }
        return size;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
           private TextView name,lost,pending,sold,customer_met;
            private Button button,button1;

        private LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            if(type==1) {
                name = (TextView) itemView.findViewById(R.id.report_dsm_name);
                lost = (TextView) itemView.findViewById(R.id.report_dsm_lost);
                pending = (TextView) itemView.findViewById(R.id.report_dsm_pending);
                sold = (TextView) itemView.findViewById(R.id.report_dsm_sold);
                customer_met = (TextView) itemView.findViewById(R.id.report_dsm_customerMet);
                button1=(Button)itemView.findViewById(R.id.dse_view);
            }
            else{ name = (TextView) itemView.findViewById(R.id.report_dse_name);
                lost = (TextView) itemView.findViewById(R.id.report_dse_lost);
                pending = (TextView) itemView.findViewById(R.id.report_dse_pending);
                sold = (TextView) itemView.findViewById(R.id.report_dse_sold);
                customer_met = (TextView) itemView.findViewById(R.id.report_dse_customerMet);
                button=(Button)itemView.findViewById(R.id.button_safe);
                linearLayout=(LinearLayout)itemView.findViewById(R.id.layout_color);
                button1=(Button)itemView.findViewById(R.id.customer_view);

            }
        }
    }
}
