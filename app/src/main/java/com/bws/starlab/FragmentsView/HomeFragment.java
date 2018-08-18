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
import com.bws.starlab.Models.PriorityJobModel;
import com.bws.starlab.R;
import android.support.v4.app.FragmentTransaction;

import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BWS on 10/05/2018.
 */

public class HomeFragment extends Fragment {
    View rootView;

    private RecyclerView recyclerView;

    Button btnPriority, btnToday, btnAll;

    List<PriorityJobModel> arrayPrioriryJob;
    private RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        initview();
        clickEvent();


        return rootView;
    }


    private void clickEvent() {
        btnPriority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayPrioriryJob.clear();

                for (int i = 0; i < 1; i++) {
                    PriorityJobModel priorityJobModel = new PriorityJobModel();
                    priorityJobModel.setStringText("Install  complete lighting solutions at  Sorrin Appartments");
                    priorityJobModel.setDate("15/04/2014");
                    priorityJobModel.setTime("10:30 a.m");
                    arrayPrioriryJob.add(priorityJobModel);
                }

                adapter = new PriorityJobAdapter(arrayPrioriryJob);
                recyclerView.setAdapter(adapter);

                btnPriority.setBackgroundResource(R.drawable.ic_priority);
                btnToday.setBackgroundResource(R.drawable.ic_priority_hover);
                btnAll.setBackgroundResource(R.drawable.ic_priority_hover);
            }
        });

        btnToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayPrioriryJob.clear();

                for (int i = 0; i < 2; i++) {
                    PriorityJobModel priorityJobModel = new PriorityJobModel();
                    priorityJobModel.setStringText("Install  complete lighting solutions at  Sorrin Appartments");
                    priorityJobModel.setDate("15/04/2014");
                    priorityJobModel.setTime("10:30 a.m");
                    arrayPrioriryJob.add(priorityJobModel);
                }

                adapter = new PriorityJobAdapter(arrayPrioriryJob);
                recyclerView.setAdapter(adapter);

                // btnToday.setBackgroundColor(getResources().getColor(R.color.color_activity_Bg));
                btnToday.setBackgroundResource(R.drawable.ic_priority);
                btnPriority.setBackgroundResource(R.drawable.ic_priority_hover);
                btnAll.setBackgroundResource(R.drawable.ic_priority_hover);
            }
        });

        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayPrioriryJob.clear();

                for (int i = 0; i < 3; i++) {
                    PriorityJobModel priorityJobModel = new PriorityJobModel();
                    priorityJobModel.setStringText("Install  complete lighting solutions at  Sorrin Appartments");
                    priorityJobModel.setDate("15/04/2014");
                    priorityJobModel.setTime("10:30 a.m");
                    arrayPrioriryJob.add(priorityJobModel);
                }

                adapter = new PriorityJobAdapter(arrayPrioriryJob);
                recyclerView.setAdapter(adapter);

                btnAll.setBackgroundResource(R.drawable.ic_priority);
                btnToday.setBackgroundResource(R.drawable.ic_priority_hover);
                btnPriority.setBackgroundResource(R.drawable.ic_priority_hover);


            }
        });

    }

    private void initview() {
       // btnLocateMap = rootView.findViewById(R.id.btnLocateMap);

        btnPriority = rootView.findViewById(R.id.btnPriority);
        btnToday = rootView.findViewById(R.id.btnToday);
        btnAll = rootView.findViewById(R.id.btnAll);
        //btnToday.setBackgroundResource(R.drawable.ic_priority);

        btnPriority.setBackgroundResource(R.drawable.ic_priority);
        btnToday.setBackgroundResource(R.drawable.ic_priority_hover);
        btnAll.setBackgroundResource(R.drawable.ic_priority_hover);

        recyclerView = rootView.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //use for recycleview devider
        Drawable dividerDrawable = ContextCompat.getDrawable(getContext(), R.drawable.line_divider);
        recyclerView.addItemDecoration(new DividerItemDecoration(dividerDrawable));


        arrayPrioriryJob = new ArrayList<PriorityJobModel>();

        for (int i = 0; i < 1; i++) {
            PriorityJobModel priorityJobModel = new PriorityJobModel();
            priorityJobModel.setStringText("Install  complete lighting solutions at  Sorrin Appartments");
            priorityJobModel.setDate("15/04/2014");
            priorityJobModel.setTime("10:30 a.m");
            arrayPrioriryJob.add(priorityJobModel);
        }

        adapter = new PriorityJobAdapter(arrayPrioriryJob);
        recyclerView.setAdapter(adapter);
    }
}
