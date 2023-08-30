package com.storedata.allviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

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


        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        binding.switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ischecked) {
                if (ischecked) {
                    binding.parenta.setBackgroundColor(Color.BLACK);
                } else {
                    binding.parenta.setBackgroundColor(Color.WHITE);
                }
            }
        });
        binding.floatingActionButton.setOnClickListener(v -> {
            startActivity(new Intent(ButtonsActivity.this, WebviewActivity.class));
        });

        binding.imageButton.setOnClickListener(v -> {
            startActivity(new Intent(ButtonsActivity.this, MainActivity.class));
        });


        binding.rradiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectedbuttonid = radioGroup.getCheckedRadioButtonId();

                if (selectedbuttonid == binding.radioButton.getId()) {

                    binding.parenta.setBackgroundColor(ContextCompat.getColor(ButtonsActivity.this, R.color.redlight));

                } else if (selectedbuttonid == binding.radioButto2.getId()) {

                    binding.parenta.setBackgroundColor(ContextCompat.getColor(ButtonsActivity.this, R.color.green));

                } else if (selectedbuttonid == binding.radioButton3.getId()) {

                    binding.parenta.setBackgroundColor(ContextCompat.getColor(ButtonsActivity.this, R.color.greendark));

                } else if (selectedbuttonid == binding.radioButto4.getId()) {

                    binding.parenta.setBackgroundColor(ContextCompat.getColor(ButtonsActivity.this, R.color.orangedark));

                }

            }
        });

    }
}