package com.storedata.allviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.storedata.allviews.databinding.ActivityMessengerDetailsBinding;

public class MessengerDetails extends AppCompatActivity {
    ActivityMessengerDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMessengerDetailsBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();

        setContentView(view);


        binding.imagesowformes.setImageResource(getIntent().getIntExtra("imageResourceId", 0));

        binding.nameformes.setText(getIntent().getStringExtra("text1"));
        binding.messagetext.setText(getIntent().getStringExtra("text2"));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                binding.progressBar.setVisibility(View.GONE);
                binding.linearLayouthideview.setVisibility(View.VISIBLE);
            }
        }, 1500);


        binding.sendbutton.setOnClickListener(v -> {
            if (binding.userreply.getText().toString().isEmpty()) {
                binding.userreply.setError("Please enter a message");
                binding.userreply.requestFocus();
                return;
            }

            String userreply = binding.userreply.getText().toString();
            binding.messagereply.setText(userreply);
            binding.replyholder.setVisibility(View.VISIBLE);


        });


    }
}