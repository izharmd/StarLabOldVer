package com.bws.starlab.FragmentManagerView;

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

import com.bws.starlab.Adapter.ManagerTimeSheetAdapter;
import com.bws.starlab.Adapter.ManagerViewSchedulAdapter;
import com.bws.starlab.Models.ManagerTimeSheet;
import com.bws.starlab.R;
import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BWS on 20/08/2018.
 */

public class ManagerViewTimeSheetFrgment extends Fragment {
    View rootView;
    RecyclerView myservice_recycler_view;
    List<ManagerTimeSheet> arrManagerTimeSheet;
    private RecyclerView.Adapter mangViewJobAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_time_sheet_manager, container, false);

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
        arrManagerTimeSheet = new ArrayList<ManagerTimeSheet>();
        for (int i = 0; i < 3; i++) {
            ManagerTimeSheet managerViewJobModel = new ManagerTimeSheet();
            managerViewJobModel.setName("Sam");
            managerViewJobModel.setDate("15/05/14");
            managerViewJobModel.setDiscription("Installation");
            managerViewJobModel.setClientName("Sorrin Aptmnts");
            arrManagerTimeSheet.add(managerViewJobModel);
        }
        mangViewJobAdapter = new ManagerTimeSheetAdapter(arrManagerTimeSheet);
        myservice_recycler_view.setAdapter(mangViewJobAdapter);
    }
}


