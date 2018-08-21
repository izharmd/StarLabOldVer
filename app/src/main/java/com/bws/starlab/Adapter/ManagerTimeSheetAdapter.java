package com.bws.starlab.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bws.starlab.ManagerViews.AproveTimesheetActivity;
import com.bws.starlab.Models.ManagerTimeSheet;
import com.bws.starlab.R;

import java.util.List;

/**
 * Created by BWS on 20/08/2018.
 */

public class ManagerTimeSheetAdapter extends RecyclerView.Adapter<ManagerTimeSheetAdapter.ViewHolder> {
    private List<ManagerTimeSheet> list;
    Context context;

    public ManagerTimeSheetAdapter(List<ManagerTimeSheet> list) {
        this.list = list;

    }

    @Override
    public ManagerTimeSheetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_time_sheet_manager, parent, false);
        return new ManagerTimeSheetAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ManagerTimeSheetAdapter.ViewHolder holder, int position) {

        if(position %2 == 1)
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#999999"));
        }
        else
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#cc7d3d"));
        }


        ManagerTimeSheet myList = list.get(position);
        holder.textName.setText(myList.getName());
        holder.textDate.setText(myList.getDate());
        holder.textDiscription.setText(myList.getDiscription());
        holder.textClentName.setText(myList.getClientName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView textName;
        public TextView textDate;
        public TextView textDiscription;
        public TextView textClentName;

        public ViewHolder(final View itemView) {
            super(itemView);

            textName = (TextView) itemView.findViewById(R.id.textName);
            textDate = (TextView) itemView.findViewById(R.id.textDate);
            textDiscription = (TextView) itemView.findViewById(R.id.textDiscription);
            textClentName = (TextView) itemView.findViewById(R.id.textClentName);


            // on item click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get position
                    int pos = getAdapterPosition();
                    if (pos == pos) {
                        // itemView.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.winter));
                    }

                    ManagerTimeSheet clickedDataItem = list.get(pos);

                    Bundle bundle = new Bundle();
                    bundle.putString("name", clickedDataItem.getName());
                    bundle.putString("location", clickedDataItem.getDate());
                    bundle.putString("type", clickedDataItem.getDiscription());
                    bundle.putString("type", clickedDataItem.getClientName());
                    Intent intent = new Intent(v.getContext(), AproveTimesheetActivity.class);
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                    ((Activity) v.getContext()).finish();

                }
            });
        }
    }

}
