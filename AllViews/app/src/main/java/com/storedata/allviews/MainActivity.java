package com.storedata.allviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.storedata.allviews.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        //setting a click listener
        binding.buttons.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ButtonsActivity.class));
        });

        binding.layouts.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, LayoutsActivity.class));
        });
        binding.textss.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, TextsActivity.class));
        });
        binding.widgets.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, WidgetsActivity.class));
        });
        binding.containers.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ContainersActivity.class));
        });

    }
}