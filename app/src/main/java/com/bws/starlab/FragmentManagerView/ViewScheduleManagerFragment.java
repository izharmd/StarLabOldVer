package com.bws.starlab.FragmentManagerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bws.starlab.Adapter.ManagerViewJobAdapter;
import com.bws.starlab.Adapter.ManagerViewSchedulAdapter;
import com.bws.starlab.Models.ManagerViewJobModel;
import com.bws.starlab.Models.ManagerViewSchedulModel;
import com.bws.starlab.R;
import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BWS on 20/08/2018.
 */

public class ViewScheduleManagerFragment extends Fragment {
    View rootView;

    FragmentManager fragmentManager;
    Fragment fragment = null;

    RecyclerView myservice_recycler_view;
    List<ManagerViewSchedulModel> arrManagerViewSchedulModel;
    private RecyclerView.Adapter mangViewJobAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_view_sechedul_manager, container, false);

        initview();
        clickEvent();


        return rootView;
    }


    private void clickEvent() {

    }

    private void initview() {


        myservice_recycler_view = (RecyclerView)rootView.findViewById(R.id.myservice_recycler_view);
        myservice_recycler_view.setHasFixedSize(true);
        myservice_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));

        Drawable dividerDrawable = ContextCompat.getDrawable(getContext(), R.drawable.line_divider);

        myservice_recycler_view.addItemDecoration(new DividerItemDecoration(dividerDrawable));

        arrManagerViewSchedulModel = new ArrayList<ManagerViewSchedulModel>();


        for (int i = 0; i < 3; i++) {
            ManagerViewSchedulModel managerViewJobModel = new ManagerViewSchedulModel();
            managerViewJobModel.setClent("Sirius Tr");
            managerViewJobModel.setDate("15/05/14");
            managerViewJobModel.setDiscription("Maintenance");
            managerViewJobModel.setNewShedule("4:30 p.m");
            arrManagerViewSchedulModel.add(managerViewJobModel);
        }

        mangViewJobAdapter = new ManagerViewSchedulAdapter(arrManagerViewSchedulModel);
        myservice_recycler_view.setAdapter(mangViewJobAdapter);
    }


}

