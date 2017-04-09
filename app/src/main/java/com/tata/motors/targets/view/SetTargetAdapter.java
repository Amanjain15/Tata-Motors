package com.tata.motors.targets.view;

import android.content.Context;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tata.motors.R;

import com.tata.motors.targets.model.data.TargetDataTsm;
import com.tata.motors.targets.model.data.TargetListDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 4/4/17.
 */

public class SetTargetAdapter extends RecyclerView.Adapter<SetTargetAdapter.MyViewHolder> {

    private LayoutInflater layoutInflater;
    private SetTargetView setTargetView;
    private Context context;
    private SetTargets setTargets;
    private List<TargetListDetails> targetListDetailses = new ArrayList<>();
    private TargetListDetails targetListDetails;


    public SetTargetAdapter(Context context, SetTargets setTargets) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        setTargetView = new SetTargets();
        this.setTargets = setTargets;
    }

    public void setData(List<TargetListDetails> targetListDetailsList) {
        this.targetListDetailses = targetListDetailsList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.set_target_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        targetListDetails = targetListDetailses.get(position);
        final MyViewHolder myViewHolder = (MyViewHolder)holder;
        myViewHolder.name.setText(targetListDetails.getUsername());
        myViewHolder.daily.setText(targetListDetails.getDaily());
        myViewHolder.monthly.setText(targetListDetails.getMonthly());
        myViewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("setTargetAdapter",position+"");
                setTargetView.dialog(targetListDetails);
            }
        });
    }

    @Override
    public int getItemCount() {
        return targetListDetailses.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,monthly,daily;
        RelativeLayout relativeLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.dsm);
            monthly =(TextView)itemView.findViewById(R.id.monthly_target);
            daily = (TextView)itemView.findViewById(R.id.daily_target);
            relativeLayout=(RelativeLayout)itemView.findViewById(R.id.target_layout);
        }

    }
}
