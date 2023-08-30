package com.storedata.allviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.storedata.allviews.databinding.ActivityTextsBinding;

public class TextsActivity extends AppCompatActivity {
    ActivityTextsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTextsBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);
    }
}