package com.bws.starlab_old_ver.ClientFragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bws.starlab_old_ver.Adapter.MyServiceAdapter;
import com.bws.starlab_old_ver.Models.MyServiceModel;
import com.bws.starlab_old_ver.R;
import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BWS on 31/08/2018.
 */

public class MyServiceFragment extends Fragment {


    View rootView;
    FragmentManager fragmentManager;
    Fragment fragment = null;

    private RecyclerView myservice_recycler_view;

    List<MyServiceModel> arrayMyService;
    private RecyclerView.Adapter myServiceAdapter;

    ImageView imv_home_client, imv_service, imv_createService, imv_invoice, imv_header;

    TextView textJob_header;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_my_service, container, false);

        initview();
        clickEvent();
        return rootView;
    }


    private void clickEvent() {

    }

    private void initview() {

      /*  imv_home_client = (ImageView)rootView.findViewById(R.id.imv_home_client);
        imv_service = (ImageView)rootView.findViewById(R.id.imv_service);
//        imv_service.setImageResource(R.mipmap.ic_service_hover);
        imv_createService = (ImageView) rootView.findViewById(R.id.imv_createService);
        imv_invoice = (ImageView) rootView.findViewById(R.id.imv_invoice);
        imv_header = (ImageView) rootView.findViewById(R.id.imv_header);


        textJob_header = (TextView) rootView.findViewById(R.id.textJob_header);
        textJob_header.setText("My Services");
*/

        myservice_recycler_view = (RecyclerView) rootView.findViewById(R.id.myservice_recycler_view);
        myservice_recycler_view.setHasFixedSize(true);
        myservice_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));

        //use for recycleview devider
        Drawable dividerDrawable = ContextCompat.getDrawable(getContext(), R.drawable.line_divider);
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
