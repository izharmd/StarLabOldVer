package com.bws.starlab.FragmentsView;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bws.starlab.Adapter.PriorityJobAdapter;
import com.bws.starlab.Adapter.ScheduleAdapter;
import com.bws.starlab.Models.PriorityJobModel;
import com.bws.starlab.Models.ScheduleModel;
import com.bws.starlab.R;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;
import java.util.List;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bws.starlab.MyJobActivity;
import com.bws.starlab.R;

/**
 * Created by BWS on 09/05/2018.
 */

public class ScheduleFragment extends Fragment {

    View rootView;

    FragmentManager fragmentManager;
    Fragment fragment = null;
    Button btnChangeSchedule;

    List<ScheduleModel> arraySchedul;
    private RecyclerView.Adapter adapter;

    RecyclerView schedule_recycler_view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_schedule, container, false);

        initview();
        clickEvent();
        return rootView;
    }


    private void clickEvent() {

        btnChangeSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new ChangeScheduleFragment();

                if (fragment != null) {
                    fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                } else {
                    Toast.makeText(getContext(), "Error in creating fragment", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void initview() {
        btnChangeSchedule = rootView.findViewById(R.id.btnChangeSchedule);
        schedule_recycler_view = rootView.findViewById(R.id.schedule_recycler_view);
        schedule_recycler_view.setHasFixedSize(true);
        schedule_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));

        //use for recycleview devider
        Drawable dividerDrawable = ContextCompat.getDrawable(getContext(), R.drawable.line_divider);
        schedule_recycler_view.addItemDecoration(new DividerItemDecoration(dividerDrawable));

        arraySchedul = new ArrayList<ScheduleModel>();

        for (int i = 0; i < 2; i++) {
            ScheduleModel scheduleModel = new ScheduleModel();
            scheduleModel.setDetails("Install  complete lighting solutions at  Sorrin Appartments");
            scheduleModel.setDate("15/04/2014");
            scheduleModel.setTime("10:30 a.m");
            arraySchedul.add(scheduleModel);
        }

        adapter = new ScheduleAdapter(arraySchedul);
        schedule_recycler_view.setAdapter(adapter);
    }
}
