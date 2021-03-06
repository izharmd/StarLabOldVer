package com.bws.starlab_old_ver.FragmentsView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.bws.starlab_old_ver.R;

/**
 * Created by BWS on 15/05/2018.
 */

public class Step1_Fragment extends Fragment {

    View rootView;
    FragmentManager fragmentManager;
    Fragment fragment = null;

    Button btnTabCustomerDetails,btnTabServiceDetails,btnTabPippeteDetails,btnTabLocation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.a_test_job_step_fragment, container, false);
        initview();
        clickEvent();

        return rootView;
    }


    private void clickEvent() {

        btnTabCustomerDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new Step1_Fragment();

                if (fragment != null) {
                    fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    btnTabCustomerDetails.setBackgroundResource(R.drawable.ic_step_blue);
                    btnTabServiceDetails.setBackgroundResource(R.drawable.ic_step_green);
                    btnTabPippeteDetails.setBackgroundResource(R.drawable.ic_step_green);
                    btnTabLocation.setBackgroundResource(R.drawable.ic_step_green);


                } else {
                    Toast.makeText(getContext(), "Error in creating fragment", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnTabServiceDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new Step2_fragment();

                if (fragment != null) {
                    fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    btnTabCustomerDetails.setBackgroundResource(R.drawable.ic_step_green);
                    btnTabServiceDetails.setBackgroundResource(R.drawable.ic_step_blue);
                    btnTabPippeteDetails.setBackgroundResource(R.drawable.ic_step_green);
                    btnTabLocation.setBackgroundResource(R.drawable.ic_step_green);
                } else {
                    Toast.makeText(getContext(), "Error in creating fragment", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnTabPippeteDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new Step3_Fragment();

                if (fragment != null) {
                    fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    btnTabCustomerDetails.setBackgroundResource(R.drawable.ic_step_green);
                    btnTabServiceDetails.setBackgroundResource(R.drawable.ic_step_green);
                    btnTabPippeteDetails.setBackgroundResource(R.drawable.ic_step_blue);
                    btnTabLocation.setBackgroundResource(R.drawable.ic_step_green);

                } else {
                    Toast.makeText(getContext(), "Error in creating fragment", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnTabLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragment = new MapFragment();

                if (fragment != null) {
                    fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    btnTabCustomerDetails.setBackgroundResource(R.drawable.ic_step_green);
                    btnTabServiceDetails.setBackgroundResource(R.drawable.ic_step_green);
                    btnTabPippeteDetails.setBackgroundResource(R.drawable.ic_step_green);
                    btnTabLocation.setBackgroundResource(R.drawable.ic_step_blue);

                } else {
                    Toast.makeText(getContext(), "Error in creating fragment", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void initview() {
        btnTabCustomerDetails = rootView.findViewById(R.id.btnTabCustomerDetails);
        btnTabServiceDetails = rootView.findViewById(R.id.btnTabServiceDetails);
        btnTabPippeteDetails = rootView.findViewById(R.id.btnTabPippeteDetails);
        btnTabLocation = rootView.findViewById(R.id.btnTabLocation);

        btnTabCustomerDetails.setBackgroundResource(R.drawable.ic_step_blue);
        btnTabServiceDetails.setBackgroundResource(R.drawable.ic_step_green);
        btnTabPippeteDetails.setBackgroundResource(R.drawable.ic_step_green);
        btnTabLocation.setBackgroundResource(R.drawable.ic_step_green);
    }

}