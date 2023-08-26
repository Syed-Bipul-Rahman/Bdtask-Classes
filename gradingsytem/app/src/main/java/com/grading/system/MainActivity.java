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


        // Get SharedPreferences instance
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        // Check if data is already saved
        boolean isDataSaved = preferences.contains("a");
        if (isDataSaved) {
//                // Data is already saved, navigate to the next page

            startActivity(new Intent(MainActivity.this, ActivityResult.class));
            finish();
        }

        binding.setvalue.setOnClickListener(v -> {
            //getting data from edit text
            String a = binding.a.getText().toString();
            String ap = binding.ap.getText().toString();
            String b = binding.b.getText().toString();
            String bp = binding.bp.getText().toString();
            String c = binding.c.getText().toString();
            String d = binding.d.getText().toString();

            if (a.isEmpty() || ap.isEmpty() || b.isEmpty() || bp.isEmpty() || c.isEmpty() || d.isEmpty()) {


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Error");
                builder.setMessage("Please fill all the fields");
                builder.setPositiveButton("OK", null);
                builder.show();
            } else {


                // Saving data
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("ap", ap);
                editor.putString("a", a);

                editor.putString("bp", bp);
                editor.putString("b", b);
                editor.putString("c", c);

                editor.putString("d", d);

                editor.apply();
//sent to next activity
                startActivity(new Intent(MainActivity.this, ActivityResult.class));
                finish();

            }


        });

    }


}