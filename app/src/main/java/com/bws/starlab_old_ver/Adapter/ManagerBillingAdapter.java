package com.bws.starlab_old_ver.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bws.starlab_old_ver.ManagerViews.BillingStatusActivity;
import com.bws.starlab_old_ver.Models.ManageBillingModel;
import com.bws.starlab_old_ver.R;

import java.util.List;

/**
 * Created by BWS on 20/08/2018.
 */

public class ManagerBillingAdapter extends RecyclerView.Adapter<ManagerBillingAdapter.ViewHolder> {
    private List<ManageBillingModel> list;
    Context context;
    FragmentManager fragmentManager;
    Fragment fragment = null;
    TextView textJob_header;


    public ManagerBillingAdapter(List<ManageBillingModel> list) {
        this.list = list;

    }

    @Override
    public ManagerBillingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_billing_manager, parent, false);
        return new ManagerBillingAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ManagerBillingAdapter.ViewHolder holder, int position) {

        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(Color.parseColor("#999999"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#cc7d3d"));
        }


        ManageBillingModel myList = list.get(position);
        holder.textBillingCode.setText(myList.getBillingCode());
        holder.textTime.setText(myList.getTime());
        holder.textRate.setText(myList.getRate());
        holder.textTotal.setText(myList.getTotal());
        holder.textClient.setText(myList.getClient());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView textBillingCode;
        public TextView textTime;
        public TextView textRate;
        public TextView textTotal;
        public TextView textClient;

        public ViewHolder(final View itemView) {
            super(itemView);

            textBillingCode = (TextView) itemView.findViewById(R.id.textBillingCode);
            textTime = (TextView) itemView.findViewById(R.id.textTime);
            textRate = (TextView) itemView.findViewById(R.id.textRate);
            textTotal = (TextView) itemView.findViewById(R.id.textTotal);
            textClient = (TextView) itemView.findViewById(R.id.textClient);


            // on item click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get position
                    int pos = getAdapterPosition();
                    if (pos == pos) {
                        // itemView.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.winter));
                    }
                   /* fragment = new BillingStatusFrament();
                    if (fragment != null) {
                        fragmentManager = ((AppCompatActivity) v.getContext()).getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                        Toast.makeText(v.getContext()," fragment  created.....",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(v.getContext()," fragment not created",Toast.LENGTH_SHORT).show();
                    }*/

                    ManageBillingModel clickedDataItem = list.get(pos);
                    Intent intent = new Intent(v.getContext(), BillingStatusActivity.class);
                    v.getContext().startActivity(intent);
                    v.getContext();

                }
            });
        }
    }

}
