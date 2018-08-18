package com.bws.starlab.FragmentsView;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.bws.starlab.CreateTimeSheetActivity;
import com.bws.starlab.R;
import android.support.v4.app.FragmentTransaction;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.SupportMapFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by BWS on 10/05/2018.
 */

public class CreateTimeSheetFragment extends Fragment {
    View rootView;

    FragmentManager fragmentManager;
    Fragment fragment = null;

    Spinner spinnerSelectJob;
    TextView textSelectdate1,textSelectdate2;
    Button btnSubmit;

    String[] arrSelectJob = { "--Select--", "Installation","Other",};
    Calendar myCalendar1 = Calendar.getInstance();
    Calendar myCalendar2 = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date1;
    DatePickerDialog.OnDateSetListener date2;
    String currentdDate;
    int dayOfMonth1,dayOfMonth2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_create_time_sheet, container, false);

        initview();
        clickEvent();

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        SupportMapFragment fragment = new SupportMapFragment();
        transaction.commit();

        return rootView;
    }


    private void clickEvent() {

        textSelectdate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date1 = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar1.set(Calendar.YEAR, year);
                        myCalendar1.set(Calendar.MONTH, monthOfYear);
                        myCalendar1.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        dayOfMonth1 = dayOfMonth;

                        String myFormat = "dd/MM/yy"; //In which you need put here
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                        textSelectdate1.setText(sdf.format(myCalendar1.getTime()));
                    }
                };

                new DatePickerDialog(getContext(), date1, myCalendar1
                        .get(Calendar.YEAR), myCalendar1.get(Calendar.MONTH),
                        myCalendar1.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        textSelectdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date2 = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar2.set(Calendar.YEAR, year);
                        myCalendar2.set(Calendar.MONTH, monthOfYear);
                        myCalendar2.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        dayOfMonth2 = dayOfMonth;
                        String myFormat = "dd/MM/yy"; //In which you need put here
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                        textSelectdate2.setText(sdf.format(myCalendar2.getTime()));
                    }
                };

                new DatePickerDialog(getContext(), date2, myCalendar2
                        .get(Calendar.YEAR), myCalendar2.get(Calendar.MONTH),
                        myCalendar2.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new CalenderFragment();

                if (fragment != null) {
                    fragmentManager = getFragmentManager();

                    Bundle args = new Bundle();
                    args.putInt("dayOfMonth1", dayOfMonth1);
                    args.putInt("dayOfMonth2", dayOfMonth2);
                    fragment.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                } else {
                    Toast.makeText(getContext(), "Error in creating fragment", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void initview() {
        btnSubmit = rootView.findViewById(R.id.btnSubmit);
        textSelectdate1 = rootView.findViewById(R.id.textSelectdate1);
        textSelectdate2 = rootView.findViewById(R.id.textSelectdate2);
        spinnerSelectJob = rootView.findViewById(R.id.spinnerSelectJob);

       // TextView textJob_header = rootView.findViewById(R.id.textJob_header);
       // textJob_header.setText("Create Timesheet");

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
       // currentdDate = df.format(c);
        textSelectdate1.setText(df.format(c));
        textSelectdate2.setText(df.format(c));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item,arrSelectJob);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerSelectJob.setAdapter(adapter);
    }
}
