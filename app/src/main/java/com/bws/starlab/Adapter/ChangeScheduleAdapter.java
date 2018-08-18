package com.bws.starlab.Adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bws.starlab.Models.ChangeScheduleModel;
import com.bws.starlab.Models.PriorityJobModel;
import com.bws.starlab.R;

import java.util.List;

/**
 * Created by BWS on 09/05/2018.
 */

public class ChangeScheduleAdapter  extends RecyclerView.Adapter<ChangeScheduleAdapter.ViewHolder> {

    private List<ChangeScheduleModel> list;

    public ChangeScheduleAdapter(List<ChangeScheduleModel> list) {
        this.list = list;

    }

    @Override
    public ChangeScheduleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemlist_change_schedule, parent, false);
        return new ChangeScheduleAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ChangeScheduleAdapter.ViewHolder holder, int position) {

        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(Color.parseColor("#999999"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#999999"));
        }

        ChangeScheduleModel myList = list.get(position);
        holder.textDetails.setText(myList.getDetails());
        holder.textDate.setText(myList.getDate());
        holder.textTime.setText(myList.getTime());
        holder.checkbox1.setText(myList.getCheckBox1());
        holder.checkbox2.setText(myList.getCheckBox2());
        holder.checkbox3.setText(myList.getCheckBox3());
        holder.checkbox4.setText(myList.getCheckBox4());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textDetails;
        public TextView textDate;
        public TextView textTime;
        public CheckBox checkbox1;
        public CheckBox checkbox2;
        public CheckBox checkbox3;
        public CheckBox checkbox4;

        public ViewHolder(View itemView) {
            super(itemView);

            textDetails = itemView.findViewById(R.id.textDetails);
            textDate = itemView.findViewById(R.id.textDate);
            textTime = itemView.findViewById(R.id.textTime);

            checkbox1 = itemView.findViewById(R.id.checkbox1);
            checkbox2 = itemView.findViewById(R.id.checkbox2);
            checkbox3 = itemView.findViewById(R.id.checkbox3);
            checkbox4 = itemView.findViewById(R.id.checkbox4);
        }
    }

}