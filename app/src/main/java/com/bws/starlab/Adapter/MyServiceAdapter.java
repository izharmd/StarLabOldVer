package com.bws.starlab.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bws.starlab.Models.MyServiceModel;
import com.bws.starlab.Models.PriorityJobModel;
import com.bws.starlab.R;

import java.util.List;

/**
 * Created by BWS on 04/05/2018.
 */

public class MyServiceAdapter extends RecyclerView.Adapter<MyServiceAdapter.ViewHolder> {

    private List<MyServiceModel> list;
    Context context;

    public MyServiceAdapter(List<MyServiceModel> list) {
        this.list = list;

    }

    @Override
    public MyServiceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_my_service, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyServiceAdapter.ViewHolder holder, int position) {

        if(position %2 == 1)
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#999999"));
        }
        else
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#cc7d3d"));
        }


        MyServiceModel myList = list.get(position);
        holder.textDate.setText(myList.getDate());
        holder.textDiscription.setText(myList.getDiscription());
        holder.textShedule.setText(myList.getShedule());
        holder.textNew.setText(myList.getStrNew());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView textDate;
        public TextView textDiscription;
        public TextView textShedule;
        public TextView textNew;

        public ViewHolder(View itemView) {
            super(itemView);

            textDate = (TextView) itemView.findViewById(R.id.textDate);
            textDiscription = (TextView) itemView.findViewById(R.id.textDiscription);
            textShedule = (TextView) itemView.findViewById(R.id.textShedule);
            textNew = (TextView) itemView.findViewById(R.id.textNew);
        }
    }

}