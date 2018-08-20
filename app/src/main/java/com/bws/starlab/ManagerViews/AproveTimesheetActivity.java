package com.bws.starlab.ManagerViews;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bws.starlab.FragmentManagerView.ManagerAssentsDetailsFragment;
import com.bws.starlab.FragmentManagerView.ManagerViewTimeSheetFrgment;
import com.bws.starlab.FragmentManagerView.ViewScheduleManagerFragment;
import com.bws.starlab.R;

public class AproveTimesheetActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    Fragment fragment = null;

    Context context;
    Activity activity;


    TextView textName,textContactPerson,textPriority,textDiscription,textdate,textLocation;
    TextView textJob_header;
    ImageView imv_Shutdown,imv_header;
    ImageView imv_Job, imv_newJob, imv_Home, imv_Schedule, imv_TimeSheet;
    Spinner spinnerJobCode;


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
        // imv_Home.setImageResource(R.mipmap.ic_home_hover);
        // imv_Home.setEnabled(false);
        imv_newJob = (ImageView) findViewById(R.id.imv_newJob);
        imv_Schedule = (ImageView) findViewById(R.id.imv_Schedule);
        imv_TimeSheet = (ImageView) findViewById(R.id.imv_TimeSheet);
        imv_TimeSheet.setImageResource(R.mipmap.ic_timesheet_hover);
        textJob_header = (TextView) findViewById(R.id.textJob_header);
        textJob_header.setText("Approve timesheet");
    }


    private void clickEvent() {


        imv_Schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new ViewScheduleManagerFragment();

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    imv_Home.setEnabled(false);
                    imv_Job.setEnabled(true);
                    imv_newJob.setEnabled(true);
                    imv_Schedule.setEnabled(true);
                    imv_TimeSheet.setEnabled(true);
                    textJob_header.setText("View  Schedule Change");
                    imv_header.setImageResource(R.mipmap.ic_jobs);
                    imv_Job.setImageResource(R.mipmap.ic_jobs);
                    imv_Schedule.setImageResource(R.mipmap.ic_schedule_hover);
                    imv_TimeSheet.setImageResource(R.mipmap.ic_timesheet);
                }

            }
        });



        imv_Job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new ManagerAssentsDetailsFragment();

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    imv_Home.setEnabled(false);
                    imv_Job.setEnabled(true);
                    imv_newJob.setEnabled(true);
                    imv_Schedule.setEnabled(true);
                    imv_TimeSheet.setEnabled(true);
                    textJob_header.setText("Job details");
                    imv_header.setImageResource(R.mipmap.ic_jobs);
                    imv_Job.setImageResource(R.mipmap.ic_jobs_hover);
                    imv_Schedule.setImageResource(R.mipmap.ic_schedule);
                    imv_TimeSheet.setImageResource(R.mipmap.ic_timesheet);
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
                    imv_Home.setEnabled(false);
                    imv_Job.setEnabled(true);
                    imv_newJob.setEnabled(true);
                    imv_Schedule.setEnabled(true);
                    imv_TimeSheet.setEnabled(true);
                    textJob_header.setText("View timesheet approvals");
                    imv_header.setImageResource(R.mipmap.ic_jobs);
                    imv_Job.setImageResource(R.mipmap.ic_jobs);
                    imv_TimeSheet.setImageResource(R.mipmap.ic_timesheet_hover);
                    imv_Schedule.setImageResource(R.mipmap.ic_schedule);
                }

            }
        });


    }
}
