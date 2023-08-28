package com.storedata.arralist_odd_numbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.storedata.arralist_odd_numbers.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {
    ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityResultBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        //get data from mainactivity

//        Bundle bundle = getIntent().getExtras();
//        if (bundle != null) {
//            binding.oddoreven.setText(bundle.getString("odd"));
//        }


//        getIntent().getStringExtra("odd");


        binding.oddoreven.setText(getIntent().getStringExtra("odd"));


    }


}