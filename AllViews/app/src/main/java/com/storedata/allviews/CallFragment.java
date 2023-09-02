package com.storedata.allviews;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class CallFragment extends Fragment {

    public CallFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_call, container, false);

        // Find the Spinner
        Spinner spinner = view.findViewById(R.id.blood_group_spinner);
        TextView textViewbloodgroup = view.findViewById(R.id.textViewCall);
        ImageView imageViewblo = view.findViewById(R.id.setimage);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle item selection here
                String selectedBloodGroup = parent.getItemAtPosition(position).toString();


                if (selectedBloodGroup.equals("A+")) {
                    textViewbloodgroup.setText("A+ Blood Group");
                    imageViewblo.setImageResource(R.drawable.aplusblood);
                } else if (selectedBloodGroup.equals("A-")) {
                    textViewbloodgroup.setText("A- Blood Group");
                    imageViewblo.setImageResource(R.drawable.aminus);
                } else if (selectedBloodGroup.equals("B+")) {
                    textViewbloodgroup.setText("B+ Blood Group");
                    imageViewblo.setImageResource(R.drawable.bplus);
                } else if (selectedBloodGroup.equals("B-")) {
                    textViewbloodgroup.setText("B- Blood Group");
                    imageViewblo.setImageResource(R.drawable.bminus);
                } else if (selectedBloodGroup.equals("AB+")) {
                    textViewbloodgroup.setText("AB+ Blood Group");
                    imageViewblo.setImageResource(R.drawable.abplus);
                } else if (selectedBloodGroup.equals("AB-")) {
                    textViewbloodgroup.setText("AB- Blood Group");
                    imageViewblo.setImageResource(R.drawable.abminus);
                } else if (selectedBloodGroup.equals("O+")) {
                    textViewbloodgroup.setText("O+ Blood Group");
                    imageViewblo.setImageResource(R.drawable.oplus);
                } else if (selectedBloodGroup.equals("O-")) {
                    textViewbloodgroup.setText("O- Blood Group");
                    imageViewblo.setImageResource(R.drawable.ominus);
                }


                Toast.makeText(getContext(), "Selected Blood Group: " + selectedBloodGroup, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle the case when nothing is selected
            }
        });

        return view;
    }
}