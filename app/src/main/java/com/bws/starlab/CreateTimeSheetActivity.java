package com.bws.starlab;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bws.starlab.FragmentsView.CreateTimeSheetFragment;
import com.bws.starlab.FragmentsView.HomeFragment;
import com.bws.starlab.FragmentsView.JobFragment;
import com.bws.starlab.FragmentsView.NewJobFragment;
import com.bws.starlab.FragmentsView.ScheduleFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CreateTimeSheetActivity extends AppCompatActivity {

    Spinner spinnerSelectJob;
    TextView textSelectdate1,textSelectdate2;
    Button btnSubmit;

    String[] arrSelectJob = { "--Select--", "Installation","Other",};
    Calendar myCalendar1 = Calendar.getInstance();
    Calendar myCalendar2 = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date1;
    DatePickerDialog.OnDateSetListener date2;
    String currentdDate;


    TextView textJob_header;
    ImageView imv_Shutdown,imv_header;
    ImageView imv_Job, imv_newJob, imv_Home, imv_Schedule, imv_TimeSheet;

    FragmentManager fragmentManager;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_time_sheet);

        intintView();
        clickEvent();
    }

    private void clickEvent() {

        textSelectdate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date1 = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar1.set(Calendar.YEAR, year);
                        myCalendar1.set(Calendar.MONTH, monthOfYear);
                        myCalendar1.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        String myFormat = "dd/MM/yy"; //In which you need put here
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                        textSelectdate1.setText(sdf.format(myCalendar1.getTime()));
                    }
                };

                new DatePickerDialog(CreateTimeSheetActivity.this, date1, myCalendar1
                        .get(Calendar.YEAR), myCalendar1.get(Calendar.MONTH),
                        myCalendar1.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        textSelectdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date2 = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar2.set(Calendar.YEAR, year);
                        myCalendar2.set(Calendar.MONTH, monthOfYear);
                        myCalendar2.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        String myFormat = "dd/MM/yy"; //In which you need put here
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                        textSelectdate2.setText(sdf.format(myCalendar2.getTime()));
                    }
                };

                new DatePickerDialog(CreateTimeSheetActivity.this, date2, myCalendar2
                        .get(Calendar.YEAR), myCalendar2.get(Calendar.MONTH),
                        myCalendar2.get(Calendar.DAY_OF_MONTH)).show();

            }
        });


        imv_Shutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CreateTimeSheetActivity.this, LoginActivity.class);
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
                    imv_header.setImageResource(R.mipmap.ic_jobs);
                } else {
                    Toast.makeText(CreateTimeSheetActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
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
                    // imv_header.setImageResource(R.mipmap.ic_jobs);
                } else {
                    Toast.makeText(CreateTimeSheetActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(CreateTimeSheetActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(CreateTimeSheetActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(CreateTimeSheetActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
                }
            }
        });



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        findViewById(R.id.textBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }





    private void intintView() {

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
        imv_TimeSheet.setEnabled(false);



        textJob_header = (TextView) findViewById(R.id.textJob_header);
        textJob_header.setText("Create New Job");



        spinnerSelectJob = (Spinner) findViewById(R.id.spinnerSelectJob);
        textSelectdate1 = (TextView) findViewById(R.id.textSelectdate1);
        textSelectdate2 = (TextView) findViewById(R.id.textSelectdate2);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        TextView textJob_header = (TextView) findViewById(R.id.textJob_header);
        textJob_header.setText("Create Timesheet");

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
        currentdDate = df.format(c);
        textSelectdate1.setText(currentdDate);
        textSelectdate2.setText(currentdDate);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item,arrSelectJob);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerSelectJob.setAdapter(adapter);
    }
}
