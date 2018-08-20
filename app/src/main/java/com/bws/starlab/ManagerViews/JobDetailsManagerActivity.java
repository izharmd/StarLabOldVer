package com.bws.starlab.ManagerViews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bws.starlab.FragmentManagerView.ManagerAssentsDetailsFragment;
import com.bws.starlab.FragmentManagerView.ManagerViewTimeSheetFrgment;
import com.bws.starlab.FragmentManagerView.ViewScheduleManagerFragment;
import com.bws.starlab.R;

public class JobDetailsManagerActivity extends AppCompatActivity {

    Button btnAssetsDetails;
    FragmentManager fragmentManager;
    Fragment fragment = null;


    TextView textName,textContactPerson,textPriority,textDiscription,textdate,textLocation;
    TextView textJob_header;
    ImageView imv_Shutdown,imv_header;
    ImageView imv_Job, imv_newJob, imv_Home, imv_Schedule, imv_TimeSheet;
    Spinner spinnerJobCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_job_details);

        initView();

        clickEvent();

        Bundle bundle = this.getIntent().getExtras();
//        textNotificationBody.setText(bundle.getString("name"));
//        textNotificationBody.setText(bundle.getString("location"));
//        textNotificationBody.setText(bundle.getString("type"));
    }

    private void clickEvent() {

        btnAssetsDetails.setOnClickListener(new View.OnClickListener() {
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
                    textJob_header.setText("Job Details");
                    imv_header.setImageResource(R.mipmap.ic_jobs);

                    imv_Job.setImageResource(R.drawable.ic_jobs_hover);
                }



            }
        });

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
                    imv_TimeSheet.setImageResource(R.mipmap.ic_timesheet_hover);
                    imv_Schedule.setImageResource(R.mipmap.ic_schedule);
                }

            }
        });
    }

    private void initView() {

        btnAssetsDetails = (Button)findViewById(R.id.btnAssetsDetails);


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

        textJob_header = (TextView) findViewById(R.id.textJob_header);
    }
}
