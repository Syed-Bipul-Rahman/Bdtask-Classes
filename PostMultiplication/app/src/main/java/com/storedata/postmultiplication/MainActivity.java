package com.storedata.postmultiplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.storedata.postmultiplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();

        setContentView(view);


        binding.getpostmultiplication.setOnClickListener(v -> {
            String starts = binding.start.getText().toString();
            String ends = binding.end.getText().toString();
            String multis = binding.multiplyby.getText().toString();


            if (starts.isEmpty() || ends.isEmpty() || multis.isEmpty()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Error");
                builder.setMessage("Please enter all the fields");

                builder.setPositiveButton("OK", (dialog, which) -> {
                    dialog.dismiss();
                });

                builder.show();
            } else {
                int start = Integer.parseInt(starts);
                int end = Integer.parseInt(ends);
                int multi = Integer.parseInt(multis);

                ArrayList<Integer> sequence = new ArrayList<>();
                //first value
                sequence.add(start);

                for (int i = start + 1; i <= end; i++) {
                    if (multi < 1) {
                        sequence.add((int) (sequence.get(i - start - 1) / multi));
                    } else if (multi > 1) {
                        sequence.add(sequence.get(i - start - 1) * (int) multi);
                    }
                }

                binding.cardview.setVisibility(View.GONE);
                binding.result.setText(sequence.toString());
                binding.result.setVisibility(View.VISIBLE);
            }


        });


    }
}