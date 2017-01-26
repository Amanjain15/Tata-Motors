package com.tata.motors.report.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tata.motors.R;
import com.tata.motors.report.model.data.Daily;
import com.tata.motors.report.model.data.Monthly;
import com.tata.motors.report.model.data.ReportData;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.MyViewHolder> {

    private ReportData reportDataList;
    private List<Daily> dailyList=new ArrayList<>();
    private List<Monthly> monthlyList=new ArrayList<>();
    int type;

    private Context context;
    private ReportView reportView;
    private LayoutInflater layoutInflater;
    private ReportFragment reportFragment;

    public ReportAdapter(Context context, ReportFragment reportFragment) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        reportView = new ReportFragment();
        this.reportFragment = reportFragment;
    }

    public void setData(ReportData reportDatas,int i) {
        reportDataList=reportDatas;
        type=i;
        dailyList=reportDatas.getDaily();
        monthlyList=reportDatas.getMonthly();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.orders_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MyViewHolder myViewHolder=(MyViewHolder) holder;
        if(type==1)
        {
            Daily daily=dailyList.get(position);
            myViewHolder.test.setText("Success");

        }

    }


    @Override
    public int getItemCount() {

        if(type==1)
            return dailyList.size();
        else
            return monthlyList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView test;
        public MyViewHolder(View itemView) {
            super(itemView);

            test=(TextView)itemView.findViewById(R.id.test);


        }

    }

}
