package com.bws.starlab.ManagerViews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bws.starlab.R;

public class ManagerJobDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_job_details);

        Bundle bundle = this.getIntent().getExtras();
//        textNotificationBody.setText(bundle.getString("name"));
//        textNotificationBody.setText(bundle.getString("location"));
//        textNotificationBody.setText(bundle.getString("type"));
    }
}
