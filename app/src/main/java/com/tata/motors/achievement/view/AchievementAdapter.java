package com.tata.motors.achievement.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tata.motors.R;
import com.tata.motors.achievement.model.data.AchievementDataDetails;
import com.tata.motors.employee.view.EmployeeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 9/4/17.
 */

public class AchievementAdapter extends RecyclerView.Adapter<AchievementAdapter.MyViewHolder> {

    private List<AchievementDataDetails>dataDetailses=new ArrayList<>();
    private AchievementView achievementView;
    private AchievementFragment achievementFragment;
    private LayoutInflater layoutInflater;
    private Context context;

    public AchievementAdapter(
                              AchievementFragment achievementFragment, Context context) {

        this.achievementView = achievementView;
        this.achievementFragment = achievementFragment;
        this.layoutInflater = layoutInflater;
        this.context = context;
    }

    public void setData(List<AchievementDataDetails> achievementDataDetails)
    {
        dataDetailses=achievementDataDetails;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.achievement_item, parent, false);
        return new AchievementAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final AchievementDataDetails achievementDataDetails=dataDetailses.get(position);
holder.sender_designation.setText(achievementDataDetails.getSender_designation());
        holder.designation.setText(achievementDataDetails.getDesignation());
        holder.name.setText(achievementDataDetails.getName());
        holder.sender_name.setText(achievementDataDetails.getSender_name());
        holder.message.setText(achievementDataDetails.getMessage());
    }

    @Override
    public int getItemCount() {
        return dataDetailses.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView sender_name,sender_designation,name,designation,message;



        public MyViewHolder(View itemView) {
            super(itemView);
            sender_designation=(TextView)itemView.findViewById(R.id.sender_designation);
            sender_name =(TextView)itemView.findViewById(R.id.sender_name);
            name=(TextView)itemView.findViewById(R.id.name);
            designation=(TextView)itemView.findViewById(R.id.designation);
            message=(TextView)itemView.findViewById(R.id.message);

        }
    }
}
