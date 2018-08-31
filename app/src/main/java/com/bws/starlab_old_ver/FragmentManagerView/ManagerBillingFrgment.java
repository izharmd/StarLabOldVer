package com.bws.starlab_old_ver.FragmentManagerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bws.starlab_old_ver.Adapter.ManagerBillingAdapter;
import com.bws.starlab_old_ver.Models.ManageBillingModel;
import com.bws.starlab_old_ver.R;
import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BWS on 20/08/2018.
 */

public class ManagerBillingFrgment extends Fragment {
    View rootView;
    RecyclerView myservice_recycler_view;
    List<ManageBillingModel> arrManageBillingModel;
    private RecyclerView.Adapter mangViewJobAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_manager_billing, container, false);

        initview();
        clickEvent();
        return rootView;
    }


    private void clickEvent() {

    }

    private void initview() {
        myservice_recycler_view = (RecyclerView) rootView.findViewById(R.id.myservice_recycler_view);
        myservice_recycler_view.setHasFixedSize(true);
        myservice_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
        Drawable dividerDrawable = ContextCompat.getDrawable(getContext(), R.drawable.line_divider);
        myservice_recycler_view.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        arrManageBillingModel = new ArrayList<ManageBillingModel>();

        for (int i = 0; i < 5; i++) {
            ManageBillingModel managerViewJobModel = new ManageBillingModel();
            managerViewJobModel.setBillingCode("INS001\n15/05/14");
            managerViewJobModel.setTime("4 hrs");
            managerViewJobModel.setRate("70");
            managerViewJobModel.setTotal("280");
            managerViewJobModel.setClient("Sorrin Aptmnts");
            arrManageBillingModel.add(managerViewJobModel);
        }
        mangViewJobAdapter = new ManagerBillingAdapter(arrManageBillingModel);
        myservice_recycler_view.setAdapter(mangViewJobAdapter);
    }
}

