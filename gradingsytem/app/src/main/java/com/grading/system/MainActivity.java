package com.grading.system;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declaration of global variables
    EditText ap, a, bp, b, c, d, userMark;
    Button checkResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //change status bar color
        getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
        //change support action bar color
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_background));


        //initialization of variables
        initall();

        checkResult.setOnClickListener(v -> {
            //call the method to check the result
            checkResult();
        });

    }

    private void checkResult() {

        //check if the user mark is empty or valid mark
        //mark cannot be greater than 100
        //mark cannot be less than 0
        //if the user mark is valid then check the result
        //if the user mark is not valid then show error message
        //user cannot leave the mark field empty
        //user cannot enter a negative mark or mark greater than 100

        if (userMark.getText().toString().isEmpty()) {
            Toast.makeText(this, "You cannot leave the field Empty", Toast.LENGTH_SHORT).show();
            userMark.setError("Please enter your mark");
            userMark.requestFocus();
            return;
        } else if (Integer.parseInt(userMark.getText().toString()) > 100) {
            Toast.makeText(this, "Mark cannot greater than 100", Toast.LENGTH_LONG).show();
            userMark.setError("Please enter a valid mark");
            userMark.requestFocus();
            return;
        } else if (Integer.parseInt(userMark.getText().toString()) < 0) {
            Toast.makeText(this, "Mark cannot less than zero", Toast.LENGTH_LONG).show();
            userMark.setError("Please enter a valid mark");
            userMark.requestFocus();
            return;
        }
        //at the end of validation check the result

        else {
            if (Integer.parseInt(userMark.getText().toString()) >= Integer.parseInt(ap.getText().toString())) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Result");
                builder.setMessage("Your Grade is A+");
                builder.setPositiveButton("OK", (dialog, which) -> {
                    dialog.dismiss();
                });
            }
        }

    }

    private void initall() {
        ap = findViewById(R.id.ap);
        a = findViewById(R.id.a);
        bp = findViewById(R.id.bp);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        userMark = findViewById(R.id.usermark);
        checkResult = findViewById(R.id.checkresult);

    }
}