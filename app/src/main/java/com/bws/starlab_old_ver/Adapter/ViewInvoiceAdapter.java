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


import com.bws.starlab_old_ver.ClientViews.InvoiceDetailsActivity;
import com.bws.starlab_old_ver.ClientViews.ViewServiceActivity;
import com.bws.starlab_old_ver.Models.MyServiceModel;
import com.bws.starlab_old_ver.Models.ViewInvoiceStatusModel;
import com.bws.starlab_old_ver.R;

import java.util.List;

/**
 * Created by BWS on 07/05/2018.
 */

public class ViewInvoiceAdapter extends RecyclerView.Adapter<ViewInvoiceAdapter.ViewHolder> {

    private List<ViewInvoiceStatusModel> list;

    public ViewInvoiceAdapter(List<ViewInvoiceStatusModel> list) {
        this.list = list;
    }

    @Override
    public ViewInvoiceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view_invoice_status, parent, false);
        return new ViewInvoiceAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewInvoiceAdapter.ViewHolder holder, int position) {

        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(Color.parseColor("#999999"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#cc7d3d"));
        }

        ViewInvoiceStatusModel myList = list.get(position);
        holder.textBillingCodeAndDate.setText(myList.getBillingCodeandDate());
        holder.textTime.setText(myList.getTime());
        holder.textRate.setText(myList.getRate());
        holder.textTotal.setText(myList.getTotal());
        holder.textDiscription.setText(myList.getDiscription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView textBillingCodeAndDate;
        public TextView textTime;
        public TextView textRate;
        public TextView textTotal;
        public TextView textDiscription;

        public ViewHolder(View itemView) {
            super(itemView);

            textBillingCodeAndDate = (TextView) itemView.findViewById(R.id.textBillingCodeAndDate);
            textTime = (TextView) itemView.findViewById(R.id.textTime);
            textRate = (TextView) itemView.findViewById(R.id.textRate);
            textTotal = (TextView) itemView.findViewById(R.id.textTotal);
            textDiscription = (TextView) itemView.findViewById(R.id.textDiscription);


            // on item click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get position
                    int pos = getAdapterPosition();
                    if (pos == pos) {
                        // itemView.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.winter));
                    }

                    ViewInvoiceStatusModel clickedDataItem = list.get(pos);

                    Bundle bundle = new Bundle();
                    bundle.putString("name", clickedDataItem.getBillingCodeandDate());
                    bundle.putString("location", clickedDataItem.getTime());
                    bundle.putString("type", clickedDataItem.getTime());
                    bundle.putString("type", clickedDataItem.getTotal());
                    bundle.putString("type", clickedDataItem.getDiscription());
                    Intent intent = new Intent(v.getContext(), InvoiceDetailsActivity.class);
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                    v.getContext();
                }
            });


        }
    }

}