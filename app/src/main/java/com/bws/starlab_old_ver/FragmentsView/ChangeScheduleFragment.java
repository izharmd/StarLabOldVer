package com.bws.starlab_old_ver.FragmentsView;

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
import android.widget.Button;
import android.widget.Toast;

import com.bws.starlab_old_ver.Adapter.ChangeScheduleAdapter;
import com.bws.starlab_old_ver.Models.ChangeScheduleModel;
import com.bws.starlab_old_ver.R;
import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BWS on 09/05/2018.
 */

public class ChangeScheduleFragment extends Fragment {
    View rootView;
    FragmentManager fragmentManager;
    Fragment fragment = null;
    Button btnApplySchedule;

    List<ChangeScheduleModel> arrayChangeSchedule;
    private RecyclerView.Adapter adapterChangeSchedule;
    RecyclerView changeSchedule_recycler_view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_change_schedule, container, false);

        initview();
        clickEvent();

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        SupportMapFragment fragment = new SupportMapFragment();
        transaction.commit();

        return rootView;
    }


    private void clickEvent() {

        btnApplySchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new ApplyScheduleFragment();

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

        btnApplySchedule = rootView.findViewById(R.id.btnApplySchedule);

        changeSchedule_recycler_view = rootView.findViewById(R.id.changeSchedule_recycler_view);
        changeSchedule_recycler_view.setHasFixedSize(true);
        changeSchedule_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));

        //use for recycleview devider
        Drawable dividerDrawable = ContextCompat.getDrawable(getContext(), R.drawable.line_divider);
        changeSchedule_recycler_view.addItemDecoration(new DividerItemDecoration(dividerDrawable));

        arrayChangeSchedule = new ArrayList<ChangeScheduleModel>();

        for (int i = 0; i < 2; i++) {
            ChangeScheduleModel changeScheduleModel = new ChangeScheduleModel();
            changeScheduleModel.setDetails("Install  complete lighting solutions at  Sorrin Appartments");
            changeScheduleModel.setDate("15/04/2014");
            changeScheduleModel.setTime("10:30 a.m");
            changeScheduleModel.setCheckBox1("");
            changeScheduleModel.setCheckBox2("10:30 a.m");
            changeScheduleModel.setCheckBox3("11:30 a.m");
            changeScheduleModel.setCheckBox4("12:30 a.m");

            arrayChangeSchedule.add(changeScheduleModel);
        }

        adapterChangeSchedule = new ChangeScheduleAdapter(arrayChangeSchedule);
        changeSchedule_recycler_view.setAdapter(adapterChangeSchedule);
    }
}
