package com.grading.system;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.grading.system.databinding.ActivityResultBinding;

public class ActivityResult extends AppCompatActivity {
private ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityResultBinding.inflate(getLayoutInflater());

        View view=binding.getRoot();

        setContentView(view);


        //change status bar color
        getWindow().setStatusBarColor(getResources().getColor(R.color.orange));

        //hinding status bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);



//        if (binding.usermark.getText().toString().isEmpty()) {
//            Toast.makeText(this, "You cannot leave the field Empty", Toast.LENGTH_SHORT).show();
//            binding.usermark.setError("Please enter your mark");
//            binding.usermark.requestFocus();
//            return;
//        } else if (Integer.parseInt(binding.usermark.getText().toString()) > 100) {
//            Toast.makeText(this, "Mark cannot greater than 100", Toast.LENGTH_LONG).show();
//            binding.usermark.setError("Please enter a valid mark");
//            binding.usermark.requestFocus();
//            return;
//        } else if (Integer.parseInt(.getText().toString()) < 0) {
//            Toast.makeText(this, "Mark cannot less than zero", Toast.LENGTH_LONG).show();
//            binding.usermark.setError("Please enter a valid mark");
//            binding.usermark.requestFocus();
//            return;
//        }
//        //at the end of validation check the result
//
//        else {
//            if (Integer.parseInt(binding.usermark.getText().toString()) >= Integer.parseInt(ap.getText().toString())) {
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setTitle("Congratulations");
//                builder.setMessage("Your Grade is A+");
//                builder.setPositiveButton("OK", (dialog, which) -> {
//                    dialog.dismiss();
//                });
//
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//
//            } else if (Integer.parseInt(binding.usermark.getText().toString()) >= Integer.parseInt(a.getText().toString())) {
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setTitle("Result");
//                builder.setMessage("Your Grade is A");
//                builder.setPositiveButton("OK", (dialog, which) -> {
//                    dialog.dismiss();
//                });
//
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//
//            } else if (Integer.parseInt(.getText().toString()) >= Integer.parseInt(bp.getText().toString())) {
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setTitle("Result");
//                builder.setMessage("Your Grade is B+");
//                builder.setPositiveButton("OK", (dialog, which) -> {
//                    dialog.dismiss();
//                });
//
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//
//            } else if (Integer.parseInt(.getText().toString()) >= Integer.parseInt(b.getText().toString())) {
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setTitle("Result");
//                builder.setMessage("Your Grade is B");
//                builder.setPositiveButton("OK", (dialog, which) -> {
//                    dialog.dismiss();
//                });
//
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//
//            } else if (Integer.parseInt(.getText().toString()) >= Integer.parseInt(c.getText().toString())) {
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setTitle("Result");
//                builder.setMessage("Your Grade is C");
//                builder.setPositiveButton("OK", (dialog, which) -> {
//                    dialog.dismiss();
//                });
//
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//
//            } else if (Integer.parseInt(.getText().toString()) >= Integer.parseInt(d.getText().toString())) {
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setTitle("Result");
//                builder.setMessage("Your Grade is D");
//                builder.setPositiveButton("OK", (dialog, which) -> {
//                    dialog.dismiss();
//                });
//
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//
//            } else if (Integer.parseInt(.getText().toString()) < Integer.parseInt(d.getText().toString())) {
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setTitle("Alas!");
//
//
//                builder.setMessage("You Are Failed");
//                builder.setPositiveButton("OK", (dialog, which) -> {
//                    dialog.dismiss();
//                });
//
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//
//            }
//        }


    }


}