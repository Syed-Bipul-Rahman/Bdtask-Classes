package com.storedata.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.storedata.fibonacci.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //view binding object
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //after clicking button fibbonacci series will be shown
        binding.btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(binding.editTextgetnum.getText().toString());
//                String fiboSeries = generateFibonacci(n);
//                binding.showmsg.setText(fiboSeries);

                String fiboTriangle = generateFibonacciTriangle(n);
                binding.showmsg.setText(fiboTriangle);


            }
        });
    }

//    private String generateFibonacci(int n) {
//        if (n <= 0) {
//            return "Invalid input";
//        }
//
//        StringBuilder result = new StringBuilder();
//        int first = 0, second = 1;
//
//        result.append(first).append(", "); // Add the first two Fibonacci numbers
//
//        for (int i = 2; i < n; i++) {
//            int next = first + second;
//            result.append(next);
//            if (i != n - 1) {
//                result.append(", ");
//            }
//
//            first = second;
//            second = next;
//        }
//
//        return result.toString();
//    }

    private String generateFibonacciTriangle(int n) {
        if (n <= 0) {
            return "Invalid input";
        }

        StringBuilder result = new StringBuilder();
        int first = 0, second = 1;
// loop for rows
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                result.append(first).append(" ");
                int next = first + second;
                first = second;
                second = next;
            }
            result.append("\n");
        }

        return result.toString();
    }


}