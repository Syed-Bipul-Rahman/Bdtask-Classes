package com.classjob.retrofitwithpicasso;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.classjob.retrofitwithpicasso.databinding.ActivityMainBinding;

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


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().hide();
        initializing();


        //bydefaoult all product will show
        getdata();


        //show category after click btn and them work respective users click
        binding.categoryshowbutn.setOnClickListener(v -> {
            binding.categoryitems.setVisibility(View.VISIBLE);
            binding.recyclerview.setVisibility(View.GONE);

            //   Toast.makeText(this, "Category", Toast.LENGTH_SHORT).show();
        });

        //handle after all product button
        binding.allproductshowbutn.setOnClickListener(v -> {
            getdata();
            binding.categoryitems.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

        });


        //show categorywise product after click on perticular category items
        binding.laptop.setOnClickListener(v -> {
            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/laptops");
            binding.recyclerview.setVisibility(View.VISIBLE);

            //Toast.makeText(this, "Laptop clicked", Toast.LENGTH_SHORT).show();
        });

        binding.smartphonesview.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/smartphones");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.fragrances.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/fragrances");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.skincare.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/skincare");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.groceries.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/groceries");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.homedecoration.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/home-decoration");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.furniture.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/furniture");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.tops.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/tops");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.womendresse.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/womens-dresses");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.womenshoes.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/womens-shoes");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.mansshirt.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/mens-shirts");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.mansshoes.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/mens-shoes");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.manwatches.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/mens-watches");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.womenwatches.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/womens-watches");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.womenbags.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/womens-bags");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.womenbags.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/womens-bags");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.juwellery.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/womens-jewellery");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.glasses.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/sunglasses");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.automotive.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/automotive");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.motorcycle.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/motorcycle");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });
        binding.lighting.setOnClickListener(v -> {

            binding.categoryitems.setVisibility(View.GONE);
            showCatitems("products/category/lighting");
            binding.recyclerview.setVisibility(View.VISIBLE);
        });


    }

    private void showCatitems(String catUrl) {
        apiInterface.getCategoryproducts(catUrl).enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                if (response.isSuccessful()) {

                    binding.progressbarContainer.setVisibility(View.GONE);


                    recyclerView.setVisibility(View.VISIBLE);
                    List<Product> products = response.body().getProducts();
                    setDataAdapter((ArrayList<Product>) products);


                    dataAdapter.notifyDataSetChanged();
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


    private void initializing() {

        recyclerView = binding.recyclerview;
        recyclerView.setHasFixedSize(true);


        Retrofit retrofit = ApiClient.getClient();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    private void getdata() {

        apiInterface.getAllProducts().enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                if (response.isSuccessful()) {

                    binding.progressbarContainer.setVisibility(View.GONE);


                    recyclerView.setVisibility(View.VISIBLE);
                    List<Product> products = response.body().getProducts();
                    setDataAdapter((ArrayList<Product>) products);

                    dataAdapter.notifyDataSetChanged();

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