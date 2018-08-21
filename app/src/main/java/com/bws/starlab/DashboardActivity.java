package com.bws.starlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bws.starlab.Commons.Common;

public class DashboardActivity extends AppCompatActivity {

    LinearLayout ll_MyJob,ll_createNewJob,ll_modifySchedule,ll_createTimeSheet,ll_MyAccount;
    ImageView imv_Shutdown;

    TextView textUserType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dahboard);
        inintView();
        clicevent();

    }

    private void clicevent() {

        ll_MyJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,MyJobActivity.class);
                startActivity(intent);
            }
        });
        ll_createNewJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,CreateJobActivity.class);
                startActivity(intent);
            }
        });

        ll_modifySchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,ModifyScheduleActivity.class);
                startActivity(intent);
            }
        });

        ll_createTimeSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,CreateTimeSheetActivity.class);
                startActivity(intent);
            }
        });
        ll_MyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,MyAccountActivity.class);
                startActivity(intent);
            }
        });

        imv_Shutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardActivity.this, LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
    }

    private void inintView() {

        ll_MyJob = (LinearLayout)findViewById(R.id.ll_MyJob);
        ll_createNewJob = (LinearLayout)findViewById(R.id.ll_createNewJob);
        ll_modifySchedule = (LinearLayout)findViewById(R.id.ll_modifySchedule);
        ll_createTimeSheet = (LinearLayout)findViewById(R.id.ll_createTimeSheet);
        ll_MyAccount = (LinearLayout)findViewById(R.id.ll_MyAccount);
        imv_Shutdown = (ImageView) findViewById(R.id.imv_Shutdown);

        textUserType = (TextView) findViewById(R.id.textUserType);
        textUserType.setText("Welcome Sam Miller Logged in as:" +" "+Common.userType);
    }
}
