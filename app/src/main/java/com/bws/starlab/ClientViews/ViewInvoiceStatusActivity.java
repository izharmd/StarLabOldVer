package com.bws.starlab.ClientViews;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bws.starlab.Adapter.MyServiceAdapter;
import com.bws.starlab.Adapter.ViewInvoiceAdapter;
import com.bws.starlab.Models.MyServiceModel;
import com.bws.starlab.Models.ViewInvoiceStatusModel;
import com.bws.starlab.R;
import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class ViewInvoiceStatusActivity extends AppCompatActivity {

    private RecyclerView viewInvoice_recycler_view;

    List<ViewInvoiceStatusModel> arrayViewInVoice;
    private RecyclerView.Adapter viewInvoiceAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_invoice_status);

        initView();
        clickEvent();
    }

    private void clickEvent() {

        findViewById(R.id.textBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {

        TextView textJob_header = (TextView) findViewById(R.id.textJob_header);
        textJob_header.setText("View Invoice");

        viewInvoice_recycler_view = (RecyclerView) findViewById(R.id.viewInvoice_recycler_view);
        viewInvoice_recycler_view.setHasFixedSize(true);
        viewInvoice_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.line_divider);
        viewInvoice_recycler_view.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        arrayViewInVoice = new ArrayList<ViewInvoiceStatusModel>();

        for (int i = 0; i < 2; i++) {
            ViewInvoiceStatusModel viewInvoiceStatusModel = new ViewInvoiceStatusModel();
            viewInvoiceStatusModel.setBillingCodeandDate("SER001\n15/05/14");
            viewInvoiceStatusModel.setTime("2hrs");
            viewInvoiceStatusModel.setRate("70");
            viewInvoiceStatusModel.setTotal("140");
            viewInvoiceStatusModel.setDiscription("Maintenance");
            arrayViewInVoice.add(viewInvoiceStatusModel);
        }

        viewInvoiceAdapter = new ViewInvoiceAdapter(arrayViewInVoice);
        viewInvoice_recycler_view.setAdapter(viewInvoiceAdapter);
    }
}
