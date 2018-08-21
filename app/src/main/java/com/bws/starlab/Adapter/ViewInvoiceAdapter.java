package com.bws.starlab.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.bws.starlab.Models.ViewInvoiceStatusModel;
import com.bws.starlab.R;

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
        }
    }

}