package com.classjob.retrofitwithpicasso;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductDetails extends AppCompatActivity {
    TextView name, brand, price, desc, categories, stock, totaltopay, ratingdetails;
    ImageView productimage, back_arroworder;
    ApiInterface apiInterface;
    String id;
    ProgressBar progressBar;
    LinearLayout linearLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        getSupportActionBar().hide();

        name = findViewById(R.id.namedetails);
        brand = findViewById(R.id.branddetails);
        price = findViewById(R.id.pricedetails);
        desc = findViewById(R.id.descdetails);
        productimage = findViewById(R.id.imagesdetails);
        progressBar = findViewById(R.id.showloadin);

        linearLayout = findViewById(R.id.linearLayout);
        back_arroworder = findViewById(R.id.back_arroworder);
        stock = findViewById(R.id.stockdetails);
        totaltopay = findViewById(R.id.totaltopayprice);
        categories = findViewById(R.id.categorydetails);
        ratingdetails = findViewById(R.id.ratingdetails);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dummyjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
        getDetails();


        back_arroworder.setOnClickListener(v -> {
            finish();
        });

    }

    private void getDetails() {
        Call<Product> callAllProducts = apiInterface.getSingleProducts("products/" + id);
        callAllProducts.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {

                if (response.isSuccessful()) {
//hide progress bar
                    linearLayout.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                    //get price for conversion
                    double productPrice = response.body().getPrice();

                    name.setText(response.body().getTitle());
                    brand.setText(response.body().getBrand());
                    categories.setText(response.body().getCategory());
                    stock.setText("Stock: " + response.body().getStock());
                    totaltopay.setText("$" + productPrice);
                    ratingdetails.setText(response.body().getRating() + " ");

                    price.setText("$" + productPrice);
                    desc.setText(response.body().getDescription());

                    //show image using picasso
                    String imageUrl = response.body().getThumbnail();
                    Picasso.get().load(imageUrl).into(productimage);
                } else {
                    Toast.makeText(ProductDetails.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
//set all products


            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(ProductDetails.this, "Failed to connect with server", Toast.LENGTH_SHORT).show();
            }


        });
    }

}
