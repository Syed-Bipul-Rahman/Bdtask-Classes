package com.storedata.loopnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //private static final int BUTTON_COUNT = 10;
    EditText start,end;
    Button showloop;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        end = findViewById(R.id.end);
        showloop = findViewById(R.id.showloop);

        showloop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int startValue = Integer.parseInt(start.getText().toString());
                int endValue = Integer.parseInt(end.getText().toString());

                ViewGroup layout = findViewById(R.id.allbuttonholder);
                layout.removeAllViews(); // Clear previous buttons if any

                for (int i = startValue; i <= endValue; i++) {
                    Button dynamicButton = new Button(MainActivity.this); // Use MainActivity.this
                    dynamicButton.setText("" + i);

                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                    );
                    dynamicButton.setLayoutParams(layoutParams);

                    final int buttonIndex = i;
                    dynamicButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "You clicked button " + buttonIndex, Toast.LENGTH_SHORT).show();
                        }
                    });

                    layout.addView(dynamicButton);
                }
            }
        });
    }
}