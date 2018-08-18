package com.bws.starlab.FragmentsView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import com.bws.starlab.R;
import android.support.v4.app.FragmentTransaction;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.SupportMapFragment;
/**
 * Created by BWS on 09/05/2018.
 */

public class NewJobFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    View rootView;

    FragmentManager fragmentManager;
    Fragment fragment = null;

    String[] arrJobCode = {"#C3456"};
    Spinner spinnerJobCode;

    Button btnAssetsDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_new_job, container, false);

        initview();
        clickEvent();

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        SupportMapFragment fragment = new SupportMapFragment();
        transaction.commit();

        return rootView;
    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getContext(),arrJobCode[position] ,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    private void clickEvent() {

        btnAssetsDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new CreateAssetsFragment();

                if (fragment != null) {
                    fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                } else {
                    Toast.makeText(getContext(), "Error in creating fragment", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void initview() {
        btnAssetsDetails = rootView.findViewById(R.id.btnAssetsDetails);

        spinnerJobCode = rootView.findViewById(R.id.spinnerJobCode);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item_job_code,arrJobCode);
        // adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerJobCode.setAdapter(adapter);
    }
}
