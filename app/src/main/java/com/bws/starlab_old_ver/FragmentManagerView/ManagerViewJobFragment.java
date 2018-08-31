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

import com.bws.starlab_old_ver.Adapter.ManagerViewJobAdapter;
import com.bws.starlab_old_ver.Models.ManagerViewJobModel;
import com.bws.starlab_old_ver.R;
import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BWS on 21/08/2018.
 */

public class ManagerViewJobFragment extends Fragment {
    View rootView;
    private RecyclerView myservice_recycler_view;
    List<ManagerViewJobModel> arrManViewJob;
    private RecyclerView.Adapter mangViewJobAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_viewjob_manager, container, false);

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
        arrManViewJob = new ArrayList<ManagerViewJobModel>();
        for (int i = 0; i < 3; i++) {
            ManagerViewJobModel managerViewJobModel = new ManagerViewJobModel();
            managerViewJobModel.setName("Md Izhar");
            managerViewJobModel.setLocation("Kolkata");
            managerViewJobModel.setType("Installation");
            arrManViewJob.add(managerViewJobModel);
        }
        mangViewJobAdapter = new ManagerViewJobAdapter(arrManViewJob);
        myservice_recycler_view.setAdapter(mangViewJobAdapter);
    }
}