package com.grading.system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //change status bar color
        getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
        //change support action bar color
       getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_background));

    }
}