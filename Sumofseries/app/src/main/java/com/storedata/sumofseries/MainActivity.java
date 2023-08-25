package com.storedata.sumofseries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import androidx.viewbinding.ViewBinding;

import com.storedata.sumofseries.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    int sum = 0;

    //view binding object

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//inflate layout
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //access

        //setonclick listener to btn
        binding.viewresultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getting text and convert them to int
                int start = Integer.parseInt(binding.startnum.getText().toString());
                int diff = Integer.parseInt(binding.defarencesbetween.getText().toString());
                int last = Integer.parseInt(binding.lastnumber.getText().toString());

                calculateSeries(start, diff, last);

            }
        });


    }

    private void calculateSeries(int start, int diff, int last) {

        for (int i = start; i <= last; i += diff) {
            sum += start + i * diff;
        }
        binding.viewtext.setText(String.valueOf(sum));
    }
}