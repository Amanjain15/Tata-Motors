package com.executives.motors.follow_up.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.executives.motors.R;
import com.executives.motors.follow_up.model.data.FollowUpListDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 11/4/17.
 */

public class FollowUpAdapter extends RecyclerView.Adapter<FollowUpAdapter.MyViewHolder>{

    private Context context;
    private LayoutInflater layoutInflater;
    private FollowUpFragment followUpFragment;
    private FollowUpView followUpView;
    private List<FollowUpListDetails> followUpListDetails = new ArrayList<>();
    private FollowUpListDetails followUpListDetail;

    public FollowUpAdapter(Context context,FollowUpFragment followUpFragment) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.followUpFragment = followUpFragment;
        this.followUpView = new FollowUpFragment();
    }

    public void setData(List<FollowUpListDetails> followUpListDetailses){
        this.followUpListDetails = followUpListDetailses;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.follow_up_item,parent,false);
        return  new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        followUpListDetail = followUpListDetails.get(position);
        holder.name.setText(followUpListDetail.getName());
        holder.date.setText(followUpListDetail.getDate());
    }

    @Override
    public int getItemCount() {

        return followUpListDetails.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,date;

        public MyViewHolder(View itemView) {
            super(itemView);

            name=(TextView)itemView.findViewById(R.id.name);
            date=(TextView)itemView.findViewById(R.id.date);

        }
    }
}
