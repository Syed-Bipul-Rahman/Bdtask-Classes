package com.classjob.retrofitwithpicasso;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.classjob.retrofitwithpicasso.cart.CartAdapter;
import com.classjob.retrofitwithpicasso.cart.CartResponse;
import com.classjob.retrofitwithpicasso.cart.Items;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CartsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CartAdapter dataAdapter;
    ArrayList<Items> arrayList;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carts);
        getSupportActionBar().hide();

        initializing();
        getdata();
    }

    private void setDataAdapter(ArrayList<Items> dataModels) {
        dataAdapter = new CartAdapter(this, dataModels);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(dataAdapter);
    }

    private void initializing() {
        recyclerView = findViewById(R.id.recyclerviewmain);
        recyclerView.setHasFixedSize(true);


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://apiholder.000webhostapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }

    private void getdata() {
        apiInterface.getCarts().enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(Call<CartResponse> call, Response<CartResponse> response) {
                if (response.isSuccessful()) {
                    List<Items> products = response.body().getData();

                    Log.d("api response","products.toString()");

                    setDataAdapter(new ArrayList<>(products));
                } else {
                    // Handle the error, e.g., show a toast message
                    Toast.makeText(CartsActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CartResponse> call, Throwable t) {
                // Handle the failure, e.g., show a toast message
                Toast.makeText(CartsActivity.this, "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
