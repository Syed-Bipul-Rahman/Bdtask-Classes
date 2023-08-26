package com.grading.system;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.grading.system.databinding.ActivityResultBinding;

public class ActivityResult extends AppCompatActivity {
    private ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityResultBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();

        setContentView(view);


        //change status bar color
        getWindow().setStatusBarColor(getResources().getColor(R.color.orange));

        //hinding status bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);


        //if user click set custom values button then data will deleted from sharedpreferescess and
        // navigate to first page

        binding.setcustomvalues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //deleting data from shared preferences
                SharedPreferences preferences = getSharedPreferences("MyPrefsFile", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();
                Toast.makeText(ActivityResult.this, "Data deleted", Toast.LENGTH_SHORT).show();
                //navigate to first page
                startActivity(new Intent(ActivityResult.this, MainActivity.class));
                finish();
            }
        });


//if user clicked on check gpa button

        binding.checkresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userMarkStr = binding.usermark.getText().toString().trim();

                if (userMarkStr.isEmpty()) {
                    binding.usermark.setError("Enter valid mark");
                    binding.usermark.requestFocus();
                    return;
                }

                //get shared preferencess
                SharedPreferences preferences = getSharedPreferences("MyPrefsFile", MODE_PRIVATE);

//get data from shared preferences
                String as = preferences.getString("a", "");
                //convert to int for calculation
                int a = Integer.parseInt(as);

                String aps = preferences.getString("ap", "");
                int ap = Integer.parseInt(aps);
                String bps = preferences.getString("bp", "");
                int bp = Integer.parseInt(bps);
                String bs = preferences.getString("b", "");
                int b = Integer.parseInt(bs);
                String cs = preferences.getString("c", "");
                int c = Integer.parseInt(cs);
                String ds = preferences.getString("d", "");
                int d = Integer.parseInt(ds);


                //get user input from edit text
                int usermarks = Integer.parseInt(binding.usermark.getText().toString());


                //check user input is valid or not

                if (usermarks > 100 || usermarks < 0) {
                    binding.usermark.setError("Enter valid mark");
                    binding.usermark.requestFocus();

                } else {

                    if (usermarks >= ap) {
                        showResultDialog("Congratulations", "Your Grade is A+");
                    } else if (usermarks >= a) {
                        showResultDialog("Congratulations", "Your Grade is A");
                    } else if (usermarks >= bp) {
                        showResultDialog("Congratulations", "Your Grade is B+");
                    } else if (usermarks >= b) {
                        showResultDialog("Congratulations", "Your Grade is B");
                    } else if (usermarks >= c) {
                        showResultDialog("Congratulations", "Your Grade is C");
                    } else if (usermarks >= d) {
                        showResultDialog("Congratulations", "Your Grade is D");
                    } else {
                        showResultDialog("Oops", "You are fail");
                    }
                }
            }
        });
    }

    private void showResultDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityResult.this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", (dialog, which) -> {
            dialog.dismiss();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


}