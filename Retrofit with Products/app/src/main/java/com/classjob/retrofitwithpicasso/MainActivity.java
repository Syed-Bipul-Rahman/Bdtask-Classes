package com.classjob.retrofitwithpicasso;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapters dataAdapter;
    ApiInterface apiInterface;
    TextView error;
    ProgressBar progressbar_home;
    ConstraintLayout constraintLayoutloading;
    ImageView allproductshow, categoryshow;
    LinearLayout categoryitems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initializing();


        //bydefaoult all product will show
        getdata();


        //show category after click btn and them work respective users click
        categoryshow.setOnClickListener(v -> {
            categoryitems.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);

            //   Toast.makeText(this, "Category", Toast.LENGTH_SHORT).show();
        });

        //handle after all product button
        allproductshow.setOnClickListener(v -> {
            getdata();
            categoryitems.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

        });

    }

    private void initializing() {

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        progressbar_home = findViewById(R.id.progressbar_home);
        constraintLayoutloading = findViewById(R.id.progressbar_container);

        allproductshow = findViewById(R.id.allproductshowbutn);
        categoryshow = findViewById(R.id.categoryshowbutn);
        categoryitems = findViewById(R.id.categoryitems);
        Retrofit retrofit = ApiClient.getClient();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    private void getdata() {

        apiInterface.getAllProducts().enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                if (response.isSuccessful()) {

                    progressbar_home.setVisibility(View.GONE);
                    constraintLayoutloading.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    List<Product> products = response.body().getProducts();
                    setDataAdapter((ArrayList<Product>) products); // Call the method to set data
                } else {
                    Toast.makeText(MainActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }


    private void setDataAdapter(ArrayList<Product> dataModels) {
        dataAdapter = new RecyclerAdapters(this, dataModels);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        //adapter

        recyclerView.setAdapter(dataAdapter);


    }
}