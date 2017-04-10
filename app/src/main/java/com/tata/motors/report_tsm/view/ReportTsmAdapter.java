package com.tata.motors.report_tsm.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tata.motors.R;
import com.tata.motors.report_tsm.model.data.ReportTsmDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 8/3/17.
 */
public class ReportTsmAdapter extends RecyclerView.Adapter<ReportTsmAdapter.MyViewHolder>{

    private List<ReportTsmDetails> reportTsmDetailsList = new ArrayList<>();
    private Context context;
    private  ReportTsmView reportTsmView;
    private ReportTsmFragment reportTsmFragment;
    private LayoutInflater layoutInflater;

    public ReportTsmAdapter(Context context, ReportTsmFragment reportTsmFragment) {
        this.context = context;
        this.reportTsmView = new ReportTsmFragment();
        this.reportTsmFragment = reportTsmFragment;
        this.layoutInflater =  LayoutInflater.from(context);

    }

    public  void  setData(List<ReportTsmDetails> reportTsmDetailses)
    {
        reportTsmDetailsList = reportTsmDetailses;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.report_tsm_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final ReportTsmDetails reportTsmDetails = reportTsmDetailsList.get(position);
         holder.type.setText(reportTsmDetails.getType());
        holder.type.setText(reportTsmDetails.getType());

    }

    @Override
    public int getItemCount() {
        return reportTsmDetailsList.size();
    }





    public class MyViewHolder extends  RecyclerView.ViewHolder{

private TextView type,name;
        public MyViewHolder(View itemView) {
            super(itemView);

            type=(TextView)itemView.findViewById(R.id.report_tsm_type);
            name=(TextView)itemView.findViewById(R.id.report_tsm_name);
        }
    }
}
