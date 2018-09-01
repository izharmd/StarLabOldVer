package com.bws.starlab_old_ver;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bws.starlab_old_ver.FragmentsView.CreateAssetsFragment;
import com.bws.starlab_old_ver.FragmentsView.CreateTimeSheetFragment;
import com.bws.starlab_old_ver.FragmentsView.HomeFragment;
import com.bws.starlab_old_ver.FragmentsView.JobFragment;
import com.bws.starlab_old_ver.FragmentsView.NewJobFragment;
import com.bws.starlab_old_ver.FragmentsView.ScheduleFragment;

public class CreateJobActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView textName,textContactPerson,textPriority,textDiscription,textdate,textLocation;
    TextView textJob_header;
    ImageView imv_Shutdown,imv_header;
    ImageView imv_Job, imv_newJob, imv_Home, imv_Schedule, imv_TimeSheet;
    Spinner spinnerJobCode;

    Button btnAssetsDetails;

    String[] arrJobCode = {"#C3456"};

    FragmentManager fragmentManager;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_job);

        initView();
        clickEvent();
    }

    private void clickEvent() {

        imv_Shutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CreateJobActivity.this, LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });

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
                    textJob_header.setText("Job Details");
                    imv_header.setImageResource(R.mipmap.ic_view_job);
                } else {
                    Toast.makeText(CreateJobActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
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
                   imv_header.setImageResource(R.mipmap.ic_view_job);
                } else {
                    Toast.makeText(CreateJobActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
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
                imv_header.setImageResource(R.mipmap.ic_createjob_client);
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
                    Toast.makeText(CreateJobActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
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
                imv_header.setImageResource(R.mipmap.ic_view_schedule);
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
                    Toast.makeText(CreateJobActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
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
                imv_header.setImageResource(R.mipmap.ic_view_job);
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
                    Toast.makeText(CreateJobActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnAssetsDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new CreateAssetsFragment();

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                } else {
                    Toast.makeText(CreateJobActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.textBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),arrJobCode[position] ,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    private void initView() {

        //Image views
        imv_Shutdown = (ImageView) findViewById(R.id.imv_Shutdown);
        imv_header = (ImageView) findViewById(R.id.imv_header);
        imv_header.setImageResource(R.mipmap.ic_view_job);
        imv_Job = (ImageView) findViewById(R.id.imv_Job);
        imv_Home = (ImageView) findViewById(R.id.imv_Home);
       // imv_Home.setImageResource(R.mipmap.ic_home_hover);
       // imv_Home.setEnabled(false);
        imv_newJob = (ImageView) findViewById(R.id.imv_newJob);
        imv_Schedule = (ImageView) findViewById(R.id.imv_Schedule);
        imv_TimeSheet = (ImageView) findViewById(R.id.imv_TimeSheet);

        //Test views
        textName = (TextView) findViewById(R.id.textName);
        textContactPerson = (TextView)findViewById(R.id.textContactPerson);
        textPriority = (TextView)findViewById(R.id.textPriority);
        textDiscription = (TextView)findViewById(R.id.textDiscription);
        textdate = (TextView)findViewById(R.id.textdate);
        textLocation = (TextView)findViewById(R.id.textLocation);

        textJob_header = (TextView) findViewById(R.id.textJob_header);
        textJob_header.setText("Create New Job");

        btnAssetsDetails = (Button) findViewById(R.id.btnAssetsDetails);
        spinnerJobCode = (Spinner) findViewById(R.id.spinnerJobCode);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_job_code,arrJobCode);
       // adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerJobCode.setAdapter(adapter);


        imv_Home.setImageResource(R.mipmap.ic_home);
        imv_newJob.setImageResource(R.mipmap.ic_newjob_hover);
        imv_newJob.setEnabled(false);
    }
}
