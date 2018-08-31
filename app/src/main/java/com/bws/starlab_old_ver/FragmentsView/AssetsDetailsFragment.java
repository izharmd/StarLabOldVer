package com.bws.starlab_old_ver.FragmentsView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.bws.starlab_old_ver.R;

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
