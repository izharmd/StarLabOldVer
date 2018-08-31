package com.bws.starlab_old_ver.ClientViews;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bws.starlab_old_ver.ClientFragment.CreateServiceFragment;
import com.bws.starlab_old_ver.ClientFragment.MyServiceFragment;
import com.bws.starlab_old_ver.ClientFragment.ViewInvoiceFragment;
import com.bws.starlab_old_ver.Commons.Common;
import com.bws.starlab_old_ver.DashBoardClientActivity;
import com.bws.starlab_old_ver.LoginActivity;
import com.bws.starlab_old_ver.MyServiceActivity;
import com.bws.starlab_old_ver.R;

public class ViewServiceActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    Fragment fragment = null;
    TextView textJob_header;
    ImageView imv_Shutdown, imv_header;
    ImageView imv_home_client,imv_service,imv_createService,imv_invoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_service);

        initView();
        clickEvent();
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
                Intent i = new Intent(ViewServiceActivity.this, LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });


        imv_home_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewServiceActivity.this, DashBoardClientActivity.class);
                startActivity(intent);
                finish();
            }
        });


        imv_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new MyServiceFragment();

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    textJob_header.setText("My service");
                    imv_header.setImageResource(R.mipmap.ic_createjob_client);
                    imv_home_client.setImageResource(R.mipmap.ic_home);
                    imv_service.setImageResource(R.mipmap.ic_service_hover);
                    imv_createService.setImageResource(R.mipmap.ic_create_service);
                    imv_invoice.setImageResource(R.mipmap.ic_invoice);
                }
            }
        });



        imv_createService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new CreateServiceFragment();

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    textJob_header.setText("Create new service request");
                    imv_header.setImageResource(R.mipmap.ic_createjob_client);
                    imv_home_client.setImageResource(R.mipmap.ic_home);
                    imv_service.setImageResource(R.mipmap.ic_service);
                    imv_createService.setImageResource(R.mipmap.ic_create_service_hover);
                    imv_invoice.setImageResource(R.mipmap.ic_invoice);
                }
            }
        });

        imv_invoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragment = new ViewInvoiceFragment();

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    textJob_header.setText("View Invoice");
                    imv_header.setImageResource(R.mipmap.ic_view_nvoice);
                    imv_home_client.setImageResource(R.mipmap.ic_home);
                    imv_service.setImageResource(R.mipmap.ic_service);
                    imv_createService.setImageResource(R.mipmap.ic_create_service);
                    imv_invoice.setImageResource(R.mipmap.ic_invoice_hover);
                }

            }
        });


    }

    private void initView() {
        //Image views
        imv_Shutdown = (ImageView) findViewById(R.id.imv_Shutdown);
        imv_header = (ImageView) findViewById(R.id.imv_header);
        imv_header.setImageResource(R.mipmap.ic_view_nvoice);
        imv_home_client = (ImageView)findViewById(R.id.imv_home_client);
        imv_service = (ImageView)findViewById(R.id.imv_service);
        imv_service.setImageResource(R.mipmap.ic_service_hover);
        imv_createService = (ImageView)findViewById(R.id.imv_createService);
        imv_invoice = (ImageView)findViewById(R.id.imv_invoice);


        textJob_header = (TextView) findViewById(R.id.textJob_header);
        textJob_header.setText("View Service details");

        TextView textUserType = (TextView) findViewById(R.id.textUserType);
        textUserType.setText("Welcome Alex Johnson Logged in as:" + " " + Common.userType);

    }
}
