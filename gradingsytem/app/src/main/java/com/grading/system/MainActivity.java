package com.grading.system;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.grading.system.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //binding object
    private ActivityMainBinding binding;

    private static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();

        setContentView(view);

        //change status bar color
        getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
        //change support action bar color
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_background));


        //initialization of variables


        binding.setvalue.setOnClickListener(v -> {
            //call the method to check the result

            // Get SharedPreferences instance
            SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

            // Check if data is already saved
            boolean isDataSaved = preferences.contains("username"); // Assuming "username" is a key you use to save data

            if (isDataSaved) {
//                // Data is already saved, navigate to the next page
//                Intent intent = new Intent(this, NextActivity.class); // Replace NextActivity with the actual next activity
//                startActivity(intent);
                startActivity(new Intent(MainActivity.this, ActivityResult.class));
                finish(); // Close the current activity
            }


        });

    }


}