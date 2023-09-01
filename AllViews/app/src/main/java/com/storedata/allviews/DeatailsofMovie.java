package com.storedata.allviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.storedata.allviews.databinding.ActivityDeatailsofMovieBinding;

public class DeatailsofMovie extends AppCompatActivity {
    ActivityDeatailsofMovieBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDeatailsofMovieBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);


        String name = getIntent().getStringExtra("name");
        String desc = getIntent().getStringExtra("description");
        String checkboxss = getIntent().getStringExtra("checkbox");
        int image = getIntent().getIntExtra("imageDrawableId", 0);

        binding.showtextmaltomal.setText("Movie Name: " + name);
        binding.showtextdetails.setText("Movie Description: " + desc + "\n");
        binding.imageviewdetails.setImageResource(image);
        binding.showcheckedvalues.setText("Movie Checkbox: " + checkboxss);

    }
}