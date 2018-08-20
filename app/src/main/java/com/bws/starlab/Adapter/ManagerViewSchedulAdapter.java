package com.bws.starlab.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bws.starlab.FragmentManagerView.ManagerAssentsDetailsFragment;
import com.bws.starlab.ManagerViews.ApproveScheduleManagerActivity;
import com.bws.starlab.ManagerViews.JobDetailsManagerActivity;
import com.bws.starlab.ManagerViews.ViewJobsActivity;
import com.bws.starlab.Models.ManagerViewJobModel;
import com.bws.starlab.Models.ManagerViewSchedulModel;
import com.bws.starlab.R;

import java.util.List;

/**
 * Created by BWS on 20/08/2018.
 */

public class ManagerViewSchedulAdapter extends RecyclerView.Adapter<ManagerViewSchedulAdapter.ViewHolder> {
    FragmentManager fragmentManager;
    Fragment fragment = null;
    private List<ManagerViewSchedulModel> list;
    Context context;

    public ManagerViewSchedulAdapter(List<ManagerViewSchedulModel> list) {
        this.list = list;

    }

    @Override
    public ManagerViewSchedulAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_manager_veiw_schedul, parent, false);
        return new ManagerViewSchedulAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ManagerViewSchedulAdapter.ViewHolder holder, int position) {

        if(position %2 == 1)
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#999999"));
        }
        else
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#cc7d3d"));
        }


        ManagerViewSchedulModel myList = list.get(position);
        holder.textClient.setText(myList.getClent());
        holder.textDate.setText(myList.getDate());
        holder.textDiscription.setText(myList.getDiscription());
        holder.textNewSchedule.setText(myList.getNewShedule());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView textClient;
        public TextView textDate;
        public TextView textDiscription;
        public TextView textNewSchedule;

        public ViewHolder(final View itemView) {
            super(itemView);

            textClient = (TextView) itemView.findViewById(R.id.textClient);
            textDate = (TextView) itemView.findViewById(R.id.textDate);
            textDiscription = (TextView) itemView.findViewById(R.id.textDiscription);
            textNewSchedule = (TextView) itemView.findViewById(R.id.textNewSchedule);


            // on item click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get position
                    int pos = getAdapterPosition();
                    if (pos == pos) {
                        // itemView.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.winter));
                    }

                    ManagerViewSchedulModel clickedDataItem = list.get(pos);

                    fragment = new ManagerAssentsDetailsFragment();

                    if (fragment != null) {

                       // Fragment fragment = new YourFragment();
                        //fragmentManager = (AppCompatActivity)context.getSupportFragmentManager();
                        //fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
//                        imv_Home.setEnabled(false);
//                        imv_Job.setEnabled(true);
//                        imv_newJob.setEnabled(true);
//                        imv_Schedule.setEnabled(true);
//                        imv_TimeSheet.setEnabled(true);
//                        textJob_header.setText("Job details");
//                        imv_header.setImageResource(R.mipmap.ic_jobs);
//                        imv_Job.setImageResource(R.mipmap.ic_jobs_hover);
//                        imv_Schedule.setImageResource(R.mipmap.ic_schedule);
                    }
                    else {
                        Toast.makeText(context,"rtyui",Toast.LENGTH_SHORT).show();
                    }


                    Bundle bundle = new Bundle();
                    bundle.putString("name", clickedDataItem.getClent());
                    bundle.putString("location", clickedDataItem.getDate());
                    bundle.putString("type", clickedDataItem.getDiscription());
                    bundle.putString("type", clickedDataItem.getNewShedule());
                    Intent intent = new Intent(v.getContext(), ApproveScheduleManagerActivity.class);
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                    ((Activity) v.getContext()).finish();

                }
            });
        }
    }

}