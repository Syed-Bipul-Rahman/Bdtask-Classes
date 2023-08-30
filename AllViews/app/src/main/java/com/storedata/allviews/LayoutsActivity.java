package com.storedata.allviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.storedata.allviews.databinding.ActivityLayoutsBinding;

public class LayoutsActivity extends AppCompatActivity {
    ActivityLayoutsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLayoutsBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);
    }
}