package com.bws.starlab_old_ver;

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

import com.bws.starlab_old_ver.Adapter.PriorityJobAdapter;
import com.bws.starlab_old_ver.FragmentsView.CreateTimeSheetFragment;
import com.bws.starlab_old_ver.FragmentsView.HomeFragment;
import com.bws.starlab_old_ver.FragmentsView.JobFragment;
import com.bws.starlab_old_ver.FragmentsView.NewJobFragment;
import com.bws.starlab_old_ver.FragmentsView.ScheduleFragment;
import com.bws.starlab_old_ver.Models.PriorityJobModel;
import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import android.widget.Button;

import android.widget.Toast;

public class MyJobActivity extends AppCompatActivity {

    TextView textJob_header;
    ImageView imv_Shutdown,imv_header;
    ImageView imv_Job, imv_newJob, imv_Home, imv_Schedule, imv_TimeSheet;
    private RecyclerView recyclerView;

  Button btnPriority, btnToday, btnAll;
    //Button  btnToday, btnAll;

    List<PriorityJobModel> arrayPrioriryJob;
    private RecyclerView.Adapter adapter;

    FragmentManager fragmentManager;
    Fragment fragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_test);

        initView();

        clickEvent();
    }

    private void clickEvent() {

        imv_Shutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MyJobActivity.this, LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });

        //=======================================================
        imv_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imv_Home.setImageResource(R.mipmap.ic_home_hover);
                imv_Job.setImageResource(R.mipmap.ic_jobs);
                imv_newJob.setImageResource(R.mipmap.ic_newjob);
                imv_Schedule.setImageResource(R.mipmap.ic_schedule);
                imv_TimeSheet.setImageResource(R.mipmap.ic_timesheet);

                fragment = new HomeFragment();

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    imv_Home.setEnabled(false);
                    imv_Job.setEnabled(true);
                    imv_newJob.setEnabled(true);
                    imv_Schedule.setEnabled(true);
                    imv_TimeSheet.setEnabled(true);
                    textJob_header.setText("My Jobs");
                    imv_header.setImageResource(R.mipmap.ic_jobs);
                } else {
                    Toast.makeText(MyJobActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
                }
            }
        });

        imv_Job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imv_Home.setImageResource(R.mipmap.ic_home);
                imv_Job.setImageResource(R.drawable.ic_jobs_hover);
                imv_newJob.setImageResource(R.mipmap.ic_newjob);
                imv_Schedule.setImageResource(R.mipmap.ic_schedule);
                imv_TimeSheet.setImageResource(R.mipmap.ic_timesheet);

                fragment = new JobFragment();

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    imv_Job.setEnabled(false);
                    imv_newJob.setEnabled(true);
                    imv_Home.setEnabled(true);
                    imv_Schedule.setEnabled(true);
                    imv_TimeSheet.setEnabled(true);
                    textJob_header.setText("Job Details");
                    imv_header.setImageResource(R.mipmap.ic_jobs);
                } else {
                    Toast.makeText(MyJobActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
                }
            }
        });

        imv_newJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imv_Home.setImageResource(R.mipmap.ic_home);
                imv_Job.setImageResource(R.mipmap.ic_jobs);
                imv_newJob.setImageResource(R.mipmap.ic_newjob_hover);
                imv_Schedule.setImageResource(R.mipmap.ic_schedule);
                imv_TimeSheet.setImageResource(R.mipmap.ic_timesheet);

                fragment = new NewJobFragment();

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    imv_newJob.setEnabled(false);
                    imv_Job.setEnabled(true);
                    imv_Home.setEnabled(true);
                    imv_Schedule.setEnabled(true);
                    imv_TimeSheet.setEnabled(true);
                    textJob_header.setText("Create Job");
                } else {
                    Toast.makeText(MyJobActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
                }
            }
        });

        imv_Schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imv_Home.setImageResource(R.mipmap.ic_home);
                imv_Job.setImageResource(R.mipmap.ic_jobs);
                imv_newJob.setImageResource(R.mipmap.ic_newjob);
                imv_Schedule.setImageResource(R.mipmap.ic_schedule_hover);
                imv_TimeSheet.setImageResource(R.mipmap.ic_timesheet);
                fragment = new ScheduleFragment();

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    //fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("").commit();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    imv_newJob.setEnabled(true);
                    imv_Job.setEnabled(true);
                    imv_Home.setEnabled(true);
                    imv_Schedule.setEnabled(false);
                    imv_TimeSheet.setEnabled(true);
                    textJob_header.setText("My Jobs");
                } else {
                    Toast.makeText(MyJobActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
                }
            }
        });

        imv_TimeSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imv_Home.setImageResource(R.mipmap.ic_home);
                imv_Job.setImageResource(R.mipmap.ic_jobs);
                imv_newJob.setImageResource(R.mipmap.ic_newjob);
                imv_Schedule.setImageResource(R.mipmap.ic_schedule);
                imv_TimeSheet.setImageResource(R.mipmap.ic_timesheet_hover);

                fragment = new CreateTimeSheetFragment();

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    //fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("").commit();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    imv_newJob.setEnabled(true);
                    imv_Job.setEnabled(true);
                    imv_Home.setEnabled(true);
                    imv_Schedule.setEnabled(true);
                    imv_TimeSheet.setEnabled(false);
                    textJob_header.setText("Create Timesheet");
                } else {
                    Toast.makeText(MyJobActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
                }
            }
        });

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

        findViewById(R.id.textBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {

        imv_Shutdown = (ImageView) findViewById(R.id.imv_Shutdown);
        imv_header = (ImageView) findViewById(R.id.imv_header);
        imv_Job = (ImageView) findViewById(R.id.imv_Job);
        imv_Home = (ImageView) findViewById(R.id.imv_Home);
        imv_Home.setImageResource(R.mipmap.ic_home_hover);
        imv_Home.setEnabled(false);
        imv_newJob = (ImageView) findViewById(R.id.imv_newJob);
        imv_Schedule = (ImageView) findViewById(R.id.imv_Schedule);
        imv_TimeSheet = (ImageView) findViewById(R.id.imv_TimeSheet);

        textJob_header = (TextView) findViewById(R.id.textJob_header);
        textJob_header.setText("My Jobs");

        btnPriority = (Button) findViewById(R.id.btnPriority);
        btnToday = (Button) findViewById(R.id.btnToday);
        btnAll = (Button) findViewById(R.id.btnAll);


        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //use for recycleview devider
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.line_divider);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        imv_Job.setEnabled(true);
    }
}