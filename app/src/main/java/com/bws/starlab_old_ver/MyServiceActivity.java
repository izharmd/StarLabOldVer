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

import com.bws.starlab_old_ver.Adapter.MyServiceAdapter;
import com.bws.starlab_old_ver.ClientFragment.CreateServiceFragment;
import com.bws.starlab_old_ver.ClientFragment.MyServiceFragment;
import com.bws.starlab_old_ver.ClientFragment.ViewInvoiceFragment;
import com.bws.starlab_old_ver.Models.MyServiceModel;
import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MyServiceActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    Fragment fragment = null;

    private RecyclerView myservice_recycler_view;

    List<MyServiceModel> arrayMyService;
    private RecyclerView.Adapter myServiceAdapter;

    ImageView imv_home_client, imv_service, imv_createService, imv_invoice, imv_header;

    TextView textJob_header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);

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

        findViewById(R.id.textBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        imv_home_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyServiceActivity.this, DashBoardClientActivity.class);
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

        imv_home_client = (ImageView) findViewById(R.id.imv_home_client);
        imv_service = (ImageView) findViewById(R.id.imv_service);
        imv_service.setImageResource(R.mipmap.ic_service_hover);
        imv_createService = (ImageView) findViewById(R.id.imv_createService);
        imv_invoice = (ImageView) findViewById(R.id.imv_invoice);
        imv_header = (ImageView) findViewById(R.id.imv_header);


        textJob_header = (TextView) findViewById(R.id.textJob_header);
        textJob_header.setText("My Services");


        myservice_recycler_view = (RecyclerView) findViewById(R.id.myservice_recycler_view);
        myservice_recycler_view.setHasFixedSize(true);
        myservice_recycler_view.setLayoutManager(new LinearLayoutManager(this));

        //use for recycleview devider
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.line_divider);
        myservice_recycler_view.addItemDecoration(new DividerItemDecoration(dividerDrawable));

        arrayMyService = new ArrayList<MyServiceModel>();


        for (int i = 0; i < 2; i++) {
            MyServiceModel myServiceModel = new MyServiceModel();
            myServiceModel.setDate("15/05/14");
            myServiceModel.setDiscription("Maintenance");
            myServiceModel.setShedule("2:30 p.m");
            myServiceModel.setStrNew("4:30 p.m");
            arrayMyService.add(myServiceModel);
        }

        myServiceAdapter = new MyServiceAdapter(arrayMyService);
        myservice_recycler_view.setAdapter(myServiceAdapter);
    }
}
