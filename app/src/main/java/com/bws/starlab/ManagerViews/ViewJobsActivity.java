package com.bws.starlab.ManagerViews;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import com.bws.starlab.Adapter.ManagerViewJobAdapter;
import com.bws.starlab.Adapter.ViewInvoiceAdapter;
import com.bws.starlab.Models.ManagerViewJobModel;
import com.bws.starlab.Models.ViewInvoiceStatusModel;
import com.bws.starlab.R;
import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class ViewJobsActivity extends AppCompatActivity {

        private RecyclerView viewInvoice_recycler_view;

        List<ManagerViewJobModel> arrManViewJob;
        private RecyclerView.Adapter mangViewJobAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_jobs);

        initView();

        clickEvent();
    }

    private void clickEvent() {

        viewInvoice_recycler_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Object obj = farmerListView.getAdapter().getItem(position);
                String value= obj.toString();
                Intent confirm = new Intent(SuitableFarmerActivity.this, ConfirmOrderActivity.class);
                confirm.putExtra("value", value);

                startActivity(confirm);

            }
        });
    }

    private void initView() {


        viewInvoice_recycler_view = (RecyclerView) findViewById(R.id.viewInvoice_recycler_view);
        viewInvoice_recycler_view.setHasFixedSize(true);
        viewInvoice_recycler_view.setLayoutManager(new LinearLayoutManager(this));

        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.line_divider);

        viewInvoice_recycler_view.addItemDecoration(new DividerItemDecoration(dividerDrawable));

        arrManViewJob = new ArrayList<ManagerViewJobModel>();


        for (int i = 0; i < 3; i++) {
            ManagerViewJobModel managerViewJobModel = new ManagerViewJobModel();
            managerViewJobModel.setName("Md Izhar");
            managerViewJobModel.setLocation("Kolkata");
            managerViewJobModel.setType("Installation");
            arrManViewJob.add(managerViewJobModel);
        }

        mangViewJobAdapter = new ManagerViewJobAdapter(arrManViewJob);
        viewInvoice_recycler_view.setAdapter(mangViewJobAdapter);
    }
}
