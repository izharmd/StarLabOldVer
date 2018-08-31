package com.bws.starlab_old_ver.ManagerViews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bws.starlab_old_ver.Commons.Common;
import com.bws.starlab_old_ver.MyAccountActivity;
import com.bws.starlab_old_ver.R;

public class DashBoardManagerActivity extends AppCompatActivity {

    LinearLayout ll_TodayJob, ll_ViewSchedule, ll_AproveTimeSheet, ll_ViewBillingStatus,
            ll_MyAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_manager);
        initView();
        clickEvent();
    }

    private void initView() {
        ll_TodayJob = (LinearLayout) findViewById(R.id.ll_TodayJob);
        ll_ViewSchedule = (LinearLayout) findViewById(R.id.ll_ViewSchedule);
        ll_AproveTimeSheet = (LinearLayout) findViewById(R.id.ll_AproveTimeSheet);
        ll_ViewBillingStatus = (LinearLayout) findViewById(R.id.ll_ViewBillingStatus);
        ll_MyAccount = (LinearLayout) findViewById(R.id.ll_MyAccount);

        TextView textUserType = (TextView) findViewById(R.id.textUserType);
        textUserType.setText("Welcome Alex Johnson Logged in as:" + " " + Common.userType);

    }

    private void clickEvent() {
        ll_TodayJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoardManagerActivity.this, ViewJobsActivity.class);
                startActivity(intent);
            }
        });
        ll_ViewSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoardManagerActivity.this, ViewScheduleActivity.class);
                startActivity(intent);
            }
        });

        ll_AproveTimeSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoardManagerActivity.this, AproveTimesheetActivity.class);
                startActivity(intent);
            }
        });

        ll_ViewBillingStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoardManagerActivity.this, BillingStatusActivity.class);
                startActivity(intent);
            }
        });
        ll_MyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoardManagerActivity.this, MyAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}
