package com.storedata.allviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.storedata.allviews.databinding.ActivityMainBinding;
import com.storedata.allviews.databinding.ActivityWidgetsBinding;

public class WidgetsActivity extends AppCompatActivity {
    ActivityWidgetsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWidgetsBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);
    }
}