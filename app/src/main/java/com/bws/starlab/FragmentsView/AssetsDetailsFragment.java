package com.bws.starlab.FragmentsView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.bws.starlab.R;
import android.support.v4.app.FragmentTransaction;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by BWS on 09/05/2018.
 */

public class AssetsDetailsFragment extends Fragment {
    Button btnLocateMap;
    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_assets_details, container, false);

        initview();
        clickEvent();
        return rootView;
    }


    private void clickEvent() {

    }

    private void initview() {
        btnLocateMap = rootView.findViewById(R.id.btnLocateMap);
    }
}
