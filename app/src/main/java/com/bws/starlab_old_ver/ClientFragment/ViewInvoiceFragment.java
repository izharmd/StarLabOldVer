package com.bws.starlab_old_ver.ClientFragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bws.starlab_old_ver.Adapter.ViewInvoiceAdapter;
import com.bws.starlab_old_ver.Models.ViewInvoiceStatusModel;
import com.bws.starlab_old_ver.R;
import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BWS on 27/08/2018.
 */

public class ViewInvoiceFragment extends Fragment {
    View rootView;
    private RecyclerView myservice_recycler_view;

    List<ViewInvoiceStatusModel> arrayViewInVoice;
    private RecyclerView.Adapter viewInvoiceAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_view_invoice, container, false);

        initview();
        clickEvent();
        return rootView;
    }


    private void clickEvent() {

    }

    private void initview() {

      //  TextView textJob_header = (TextView)rootView.findViewById(R.id.textJob_header);
    //    textJob_header.setText("View Invoice");

        myservice_recycler_view = (RecyclerView)rootView.findViewById(R.id.myservice_recycler_view);
        myservice_recycler_view.setHasFixedSize(true);
        myservice_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
        Drawable dividerDrawable = ContextCompat.getDrawable(getContext(), R.drawable.line_divider);
        myservice_recycler_view.addItemDecoration(new DividerItemDecoration(dividerDrawable));
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
        myservice_recycler_view.setAdapter(viewInvoiceAdapter);
    }

}

