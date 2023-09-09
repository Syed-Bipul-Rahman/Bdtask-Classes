package com.classwork.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView productname, productprice;
    ImageView productimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        productimage = findViewById(R.id.productimagessingle);
        productname = findViewById(R.id.productnamesingle);
        productprice = findViewById(R.id.productpricesingle);

        getSupportActionBar().hide();

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int imagess = intent.getIntExtra("image", 0);
        String price = intent.getStringExtra("price");


        productimage.setImageResource(imagess);
        productname.setText(name);

        productprice.setText(price);

    }
}