package com.bws.starlab_old_ver.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bws.starlab_old_ver.ClientViews.ViewServiceActivity;
import com.bws.starlab_old_ver.Models.MyServiceModel;
import com.bws.starlab_old_ver.R;

import java.util.List;

/**
 * Created by BWS on 04/05/2018.
 */

public class MyServiceAdapter extends RecyclerView.Adapter<MyServiceAdapter.ViewHolder> {
    private List<MyServiceModel> list;

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

        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(Color.parseColor("#999999"));
        } else {
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

            // on item click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get position
                    int pos = getAdapterPosition();
                    if (pos == pos) {
                        // itemView.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.winter));
                    }

                    MyServiceModel clickedDataItem = list.get(pos);

                    Bundle bundle = new Bundle();
                    bundle.putString("name", clickedDataItem.getDate());
                    bundle.putString("location", clickedDataItem.getDiscription());
                    bundle.putString("type", clickedDataItem.getShedule());
                    bundle.putString("type", clickedDataItem.getStrNew());
                    Intent intent = new Intent(v.getContext(), ViewServiceActivity.class);
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                    ((Activity) v.getContext()).finish();
                }
            });

        }
    }
}