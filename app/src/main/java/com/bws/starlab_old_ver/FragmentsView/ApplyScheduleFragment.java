package com.bws.starlab_old_ver.FragmentsView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bws.starlab_old_ver.R;

/**
 * Created by BWS on 09/05/2018.
 */

public class ApplyScheduleFragment extends Fragment {
    View rootView;

    FragmentManager fragmentManager;
    Fragment fragment = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_apply_schedule, container, false);

        initview();
        clickEvent();
        return rootView;
    }


    private void clickEvent() {

    }

    private void initview() {

    }
}
