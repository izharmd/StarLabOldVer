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

import com.bws.starlab.ManagerViews.ManagerJobDetailsActivity;
import com.bws.starlab.Models.ManagerViewJobModel;
import com.bws.starlab.R;

import java.util.List;

/**
 * Created by BWS on 18/08/2018.
 */

public class ManagerViewJobAdapter extends RecyclerView.Adapter<ManagerViewJobAdapter.ViewHolder> {

    private List<ManagerViewJobModel> list;
    Context context;

    public ManagerViewJobAdapter(List<ManagerViewJobModel> list) {
        this.list = list;

    }

    @Override
    public ManagerViewJobAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_manager_view_job, parent, false);
        return new ManagerViewJobAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ManagerViewJobAdapter.ViewHolder holder, int position) {

        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(Color.parseColor("#999999"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#cc7d3d"));
        }

        ManagerViewJobModel myList = list.get(position);
        holder.textName.setText(myList.getName());
        holder.textLocation.setText(myList.getLocation());
        holder.textType.setText(myList.getType());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView textName;
        public TextView textLocation;
        public TextView textType;

        public ViewHolder(View itemView) {
            super(itemView);

            textName = (TextView) itemView.findViewById(R.id.textName);
            textLocation = (TextView) itemView.findViewById(R.id.textLocation);
            textType = (TextView) itemView.findViewById(R.id.textType);

            // on item click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get position
                    int pos = getAdapterPosition();
                    if (pos == pos) {
                        // itemView.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.winter));
                    }

                    ManagerViewJobModel clickedDataItem = list.get(pos);

                    Bundle bundle = new Bundle();
                    bundle.putString("name", clickedDataItem.getName());
                    bundle.putString("location", clickedDataItem.getLocation());
                    bundle.putString("type", clickedDataItem.getType());
                    Intent intent = new Intent(v.getContext(), ManagerJobDetailsActivity.class);
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                    ((Activity) v.getContext()).finish();

                }
            });


        }
    }

}