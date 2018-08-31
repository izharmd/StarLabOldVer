package com.bws.starlab_old_ver.Adapter;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bws.starlab_old_ver.Models.ScheduleModel;
import com.bws.starlab_old_ver.R;

import java.util.List;
/**
 * Created by BWS on 09/05/2018.
 */

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    private List<ScheduleModel> list;

    public ScheduleAdapter(List<ScheduleModel> list) {
        this.list = list;
    }

    @Override
    public ScheduleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemlist_schedule, parent, false);
        return new ScheduleAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ScheduleAdapter.ViewHolder holder, int position) {

        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(Color.parseColor("#999999"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#999999"));
        }
        ScheduleModel myList = list.get(position);
        holder.textDetails.setText(myList.getDetails());
        holder.textDate.setText(myList.getDate());
        holder.textTime.setText(myList.getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textDetails;
        public TextView textDate;
        public TextView textTime;

        public ViewHolder(View itemView) {
            super(itemView);

            textDetails = (TextView) itemView.findViewById(R.id.textDetails);
            textDate = (TextView) itemView.findViewById(R.id.textDate);
            textTime = (TextView) itemView.findViewById(R.id.textTime);
        }
    }

}