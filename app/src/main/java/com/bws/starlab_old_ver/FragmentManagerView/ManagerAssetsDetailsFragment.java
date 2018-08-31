package com.bws.starlab_old_ver.FragmentManagerView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bws.starlab_old_ver.R;

/**
 * Created by BWS on 20/08/2018.
 */

public class ManagerAssetsDetailsFragment extends Fragment {
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_manager_assets_details, container, false);

        initview();
        clickEvent();

        return rootView;
    }

    private void clickEvent() {

    }

    private void initview() {

    }
}
