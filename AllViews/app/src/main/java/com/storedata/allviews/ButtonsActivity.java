package com.storedata.allviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.storedata.allviews.databinding.ActivityButtonsBinding;
import com.storedata.allviews.databinding.ActivityMainBinding;

public class ButtonsActivity extends AppCompatActivity {
    ActivityButtonsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityButtonsBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);



    }
}