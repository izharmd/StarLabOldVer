package com.bws.starlab_old_ver.ManagerViews;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bws.starlab_old_ver.Adapter.ManagerTimeSheetAdapter;
import com.bws.starlab_old_ver.Commons.Common;
import com.bws.starlab_old_ver.FragmentManagerView.ManagerBillingFrgment;
import com.bws.starlab_old_ver.FragmentManagerView.ManagerViewJobFragment;
import com.bws.starlab_old_ver.FragmentManagerView.ManagerViewTimeSheetFrgment;
import com.bws.starlab_old_ver.FragmentManagerView.ViewScheduleManagerFragment;
import com.bws.starlab_old_ver.LoginActivity;
import com.bws.starlab_old_ver.Models.ManagerTimeSheet;
import com.bws.starlab_old_ver.R;
import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class AproveTimesheetActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    Fragment fragment = null;
    TextView textJob_header;
    ImageView imv_Shutdown,imv_header;
    ImageView imv_Job, imv_newJob, imv_Home, imv_Schedule, imv_TimeSheet;


    RecyclerView myservice_recycler_view;
    List<ManagerTimeSheet> arrManagerTimeSheet;
    private RecyclerView.Adapter mangViewJobAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprove_timesheet);

        initView();
        clickEvent();
    }

    private void initView() {

        //Image views
        imv_Shutdown = (ImageView) findViewById(R.id.imv_Shutdown);
        imv_header = (ImageView) findViewById(R.id.imv_header);
        imv_Job = (ImageView) findViewById(R.id.imv_Job);
        imv_Home = (ImageView) findViewById(R.id.imv_Home);
        imv_newJob = (ImageView) findViewById(R.id.imv_newJob);

        imv_header = (ImageView) findViewById(R.id.imv_header);
        imv_header.setImageResource(R.mipmap.ic_view_job);

        imv_Schedule = (ImageView) findViewById(R.id.imv_Schedule);
        imv_TimeSheet = (ImageView) findViewById(R.id.imv_TimeSheet);
        imv_TimeSheet.setImageResource(R.mipmap.ic_timesheet_hover);
        textJob_header = (TextView) findViewById(R.id.textJob_header);
        textJob_header.setText("Approve timesheet");

        if (Common.userType.equals("Service Manager")) {
            imv_newJob.setImageResource(R.mipmap.ic_billing);
        }


        TextView textUserType = (TextView) findViewById(R.id.textUserType);
        textUserType.setText("Welcome Alex Johnson Logged in as:" +" "+ Common.userType);


        myservice_recycler_view = (RecyclerView) findViewById(R.id.myservice_recycler_view);
        myservice_recycler_view.setHasFixedSize(true);
        myservice_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.line_divider);
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
    private void clickEvent() {

        findViewById(R.id.textBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        imv_Shutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AproveTimesheetActivity.this, LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });


        imv_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // imv_Home.setImageResource(R.mipmap.ic_home_hover);
               // Intent i = new Intent(AproveTimesheetActivity.this, DashBoardManagerActivity.class);
                //startActivity(i);
                finish();
            }
        });

        imv_Schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new ViewScheduleManagerFragment();

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    textJob_header.setText("View  Schedule Change");
                    imv_header.setImageResource(R.mipmap.ic_view_schedule);
                    imv_Home.setImageResource(R.mipmap.ic_home);
                    imv_Job.setImageResource(R.mipmap.ic_jobs);
                    imv_newJob.setImageResource(R.mipmap.ic_billing);
                    imv_Schedule.setImageResource(R.mipmap.ic_schedule_hover);
                    imv_TimeSheet.setImageResource(R.mipmap.ic_timesheet);
                }

            }
        });

        imv_Job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new ManagerViewJobFragment();

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    textJob_header.setText("Job details");
                    imv_header.setImageResource(R.mipmap.ic_view_job);
                    imv_Home.setImageResource(R.mipmap.ic_home);
                    imv_Job.setImageResource(R.mipmap.ic_jobs_hover);
                    imv_newJob.setImageResource(R.mipmap.ic_billing);

                    imv_Schedule.setImageResource(R.mipmap.ic_schedule);
                    imv_TimeSheet.setImageResource(R.mipmap.ic_timesheet);
                }
            }
        });


        imv_newJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new ManagerBillingFrgment();

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    textJob_header.setText("View Billing");
                    imv_header.setImageResource(R.mipmap.ic_view_billing);
                    imv_Home.setImageResource(R.mipmap.ic_home);
                    imv_Job.setImageResource(R.mipmap.ic_jobs);
                    imv_TimeSheet.setImageResource(R.mipmap.ic_timesheet);
                    imv_Schedule.setImageResource(R.mipmap.ic_schedule);
                    imv_newJob.setImageResource(R.mipmap.ic_billing_hover);
                }

            }
        });

        imv_TimeSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new ManagerViewTimeSheetFrgment();
                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    textJob_header.setText("View timesheet approvals");
                    imv_header.setImageResource(R.mipmap.ic_view_job);
                    imv_Home.setImageResource(R.mipmap.ic_home);
                    imv_Job.setImageResource(R.mipmap.ic_jobs);
                    imv_newJob.setImageResource(R.mipmap.ic_billing);

                    imv_TimeSheet.setImageResource(R.mipmap.ic_timesheet_hover);
                    imv_Schedule.setImageResource(R.mipmap.ic_schedule);
                }
            }
        });
    }
}
