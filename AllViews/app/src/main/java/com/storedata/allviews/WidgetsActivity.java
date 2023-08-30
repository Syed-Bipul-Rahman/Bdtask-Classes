package com.storedata.allviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import com.storedata.allviews.databinding.ActivityMainBinding;
import com.storedata.allviews.databinding.ActivityWidgetsBinding;

import java.net.URI;

public class WidgetsActivity extends AppCompatActivity {
    ActivityWidgetsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWidgetsBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        binding.viewonweb.setOnClickListener(view1 -> {
            startActivity(new Intent(WidgetsActivity.this, WebviewActivity.class));
        });

        //video view
        int vidrawid = getResources().getIdentifier("sample", "raw", getPackageName());
        String videopath = "android.resource://" + getPackageName() + "/" + vidrawid;
        binding.videoView.setVideoURI(Uri.parse(videopath));
        binding.videoView.start();


        //ratingbar
        binding.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(WidgetsActivity.this, "Your rating" + v, Toast.LENGTH_SHORT).show();
            }
        });

        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(WidgetsActivity.this, "Progress" + i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}