package com.bws.starlab;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bws.starlab.Adapter.MyServiceAdapter;
import com.bws.starlab.Adapter.PriorityJobAdapter;
import com.bws.starlab.Models.MyServiceModel;
import com.bws.starlab.Models.PriorityJobModel;
import com.bws.starlab.Utils.SpacesItemDecoration;
import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MyServiceActivity extends AppCompatActivity {

    private RecyclerView myservice_recycler_view;

    List<MyServiceModel> arrayMyService;
    private RecyclerView.Adapter myServiceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);

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

        findViewById(R.id.textBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {

        TextView textJob_header = (TextView) findViewById(R.id.textJob_header);
        textJob_header.setText("My Services");


        myservice_recycler_view = (RecyclerView) findViewById(R.id.myservice_recycler_view);
        myservice_recycler_view.setHasFixedSize(true);
        myservice_recycler_view.setLayoutManager(new LinearLayoutManager(this));

        //use for recycleview devider
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.line_divider);
        myservice_recycler_view.addItemDecoration(new DividerItemDecoration(dividerDrawable));

        arrayMyService = new ArrayList<MyServiceModel>();


        for (int i = 0; i < 2; i++) {
            MyServiceModel myServiceModel = new MyServiceModel();
            myServiceModel.setDate("15/05/14");
            myServiceModel.setDiscription("Maintenance");
            myServiceModel.setShedule("2:30 p.m");
            myServiceModel.setStrNew("4:30 p.m");
            arrayMyService.add(myServiceModel);
        }

        myServiceAdapter = new MyServiceAdapter(arrayMyService);
        myservice_recycler_view.setAdapter(myServiceAdapter);
    }
}
