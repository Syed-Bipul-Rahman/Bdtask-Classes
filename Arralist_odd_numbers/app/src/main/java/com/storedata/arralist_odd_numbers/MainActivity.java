package com.storedata.arralist_odd_numbers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.storedata.arralist_odd_numbers.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//set contentent view with view binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.odd.setOnClickListener(v -> {
            //checking if fields is empty show alert dialog
            String textstart = binding.startnumber.getText().toString();
            String textend = binding.end.getText().toString();

            //arraylist to store
            ArrayList<Integer> aodd = new ArrayList<>();
            if (textstart.isEmpty() || textend.isEmpty()) {
                //alert dialoge medhod call
                showAlert();

            } else {

                int startnumber = Integer.parseInt(textstart);
                int endnumber = Integer.parseInt(textend);

                for (int i = startnumber; i <= endnumber; i++) {
                    if (i % 2 != 0) {
                        aodd.add(i);
                        //send to resultactivity with data
                        //  startActivity(new Intent(MainActivity.this, ResultActivity.class));


//                        Toast.makeText(this, "odd number"+odd, Toast.LENGTH_SHORT).show();


                        //show test data

                        //                    binding.shoeee.setText(aodd.toString());

                    }
                }
//Navigate to Result activity
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("odd", aodd.toString());
                startActivity(intent);

            }


        });
        binding.even.setOnClickListener(v -> {
            //checking if fields is empty show alert dialog
            String textstart = binding.startnumber.getText().toString();
            String textend = binding.end.getText().toString();

            //arraylist to store
            ArrayList<Integer> aodd = new ArrayList<>();
            if (textstart.isEmpty() || textend.isEmpty()) {
                //alert dialoge medhod call
                showAlert();

            } else {

                int startnumber = Integer.parseInt(textstart);
                int endnumber = Integer.parseInt(textend);

                for (int i = startnumber; i <= endnumber; i++) {
                    if (i % 2 == 0) {
                        aodd.add(i);
                        //send to resultactivity
                        //  startActivity(new Intent(MainActivity.this, ResultActivity.class));


//                        Toast.makeText(this, "odd number"+odd, Toast.LENGTH_SHORT).show();


                        //show test data

                        //                    binding.shoeee.setText(aodd.toString());

                    }
                }
//Navigate to Result activity
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("odd", aodd.toString());
                startActivity(intent);

            }


        });

    }


    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Error");
        builder.setIcon(R.drawable.ic_baseline_error_outline_24);
        builder.setMessage("Fields cannot be empty");
        builder.setPositiveButton("Ok", (dialog, which) -> {
            dialog.dismiss();
        });
        builder.show();

    }
}