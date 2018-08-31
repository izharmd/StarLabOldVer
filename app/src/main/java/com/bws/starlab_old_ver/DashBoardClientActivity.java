package com.bws.starlab_old_ver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bws.starlab_old_ver.ClientViews.CreateServiceRequestActivity;
import com.bws.starlab_old_ver.ClientViews.ViewInvoiceStatusActivity;
import com.bws.starlab_old_ver.Commons.Common;

public class DashBoardClientActivity extends AppCompatActivity {

   LinearLayout ll_MyService,ll_createServiceReq;

    TextView textUserType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_client);

        initView();
        clickevent();
    }

    private void clickevent() {

        ll_MyService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoardClientActivity.this,MyServiceActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.ll_createServiceReq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoardClientActivity.this,CreateServiceRequestActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.ll_ViewInvoice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoardClientActivity.this,ViewInvoiceStatusActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.ll_MyAccount_Client).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoardClientActivity.this,MyAccountActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {

        ll_MyService = (LinearLayout) findViewById(R.id.ll_MyService);

        textUserType = (TextView) findViewById(R.id.textUserType);
        textUserType.setText("Welcome Alex Johnson Logged in as:" +" "+ Common.userType);
    }
}
