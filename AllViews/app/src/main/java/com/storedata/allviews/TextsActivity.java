package com.storedata.allviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.storedata.allviews.databinding.ActivityTextsBinding;

public class TextsActivity extends AppCompatActivity {
    ActivityTextsBinding binding;

    String[] text = {"Java", "Javascript", "python", "rahim", "Karim", "ruby", "laravel", "PHP", "there", "is", "nothing", "knowladge", "challange", "clearly", "you", "are", "foolish"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTextsBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, text);
        binding.multiAutoComplete.setAdapter(arrayAdapter);
        binding.multiAutoComplete.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        //  getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);


        //menue

        //setting a click listener
        binding.buttons.setOnClickListener(v -> {
            startActivity(new Intent(TextsActivity.this, ButtonsActivity.class));
        });

        binding.layouts.setOnClickListener(v -> {
            startActivity(new Intent(TextsActivity.this, LayoutsActivity.class));
        });
        binding.textss.setOnClickListener(v -> {
            startActivity(new Intent(TextsActivity.this, TextsActivity.class));
        });
        binding.widgets.setOnClickListener(v -> {
            startActivity(new Intent(TextsActivity.this, WidgetsActivity.class));
        });
        binding.containers.setOnClickListener(v -> {
            startActivity(new Intent(TextsActivity.this, ContainersActivity.class));
        });


        //geting all text from input fields and set them in text view
        binding.button.setOnClickListener(v -> {

            String t1 = binding.textInputEditText.getText().toString();
            String t2 = binding.editTextPhone.getText().toString();
            String t3 = binding.editTextNumberPassword.getText().toString();
            String t4 = binding.editTextTextPersonName.getText().toString();
            String t5 = binding.editTextTextPassword.getText().toString();
            String t6 = binding.editTextTextEmailAddress.getText().toString();
            String t7 = binding.editTextTextPostalAddress.getText().toString();
            String t8 = binding.editTextTextMultiLine.getText().toString();
            String t9 = binding.editTextTime.getText().toString();
            String t10 = binding.editTextDate.getText().toString();
            String t11 = binding.editTextNumber.getText().toString();
            String t12 = binding.editTextNumberSigned.getText().toString();
            String t13 = binding.editTextNumberDecimal.getText().toString();


            //validating
            if (t1.isEmpty() || t2.isEmpty() || t3.isEmpty() || t4.isEmpty() || t5.isEmpty() || t6.isEmpty() || t7.isEmpty() || t8.isEmpty() || t9.isEmpty() || t10.isEmpty() || t11.isEmpty() || t12.isEmpty() || t13.isEmpty()) {
                binding.textView.setText("Please fill all fields");
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                binding.textView.setText("Your Texts is: \n textInputEditText: " + t1 + "\n editTextPhone: " + t2
                        + "\n editTextNumberPassword: " + t3 + "\n editTextTextPersonName: " + t4 + "\n editTextTextPassword: " +
                        t5 + "\n editTextTextEmailAddress: " + t6 + "\n editTextTextPostalAddress: " + t7 + "\n editTextTextMultiLine: "
                        + t8 + "\n editTextTime: " + t9 + "\n editTextDate: " + t10
                        + "\n editTextNumber: " + t11 + "\n editTextNumberSigned " + t12 + "\n editTextNumberDecimal: "
                        + t13);

            }

        });


    }
}
