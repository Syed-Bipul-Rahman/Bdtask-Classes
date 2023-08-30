package com.storedata.allviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.storedata.allviews.databinding.ActivityContainersBinding;

public class ContainersActivity extends AppCompatActivity {
    ActivityContainersBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContainersBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);
    }
}