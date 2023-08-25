package com.storedata.factorial;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {
    EditText getnumber;
    Button getfactorial;
    TextView setresult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialization
        getnumber = findViewById(R.id.numbersfor);
        getfactorial = findViewById(R.id.get);
        setresult = findViewById(R.id.setvalue);


        //action set
        getfactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //geting number from user input and convert it to int
                int x = Integer.parseInt(getnumber.getText().toString());
                BigInteger getfact = getfactorials(x);

                setresult.setText("Your factorial is : "+String.valueOf(getfact));
            }
        });


    }

    private BigInteger getfactorials(int num) {
        // Base case: factorial of 0 or 1 is 1
        if (num == 0 || num == 1) {
            return BigInteger.ONE;
        }

        // Recursive case
        return BigInteger.valueOf(num).multiply(getfactorials(num - 1));
    }
}