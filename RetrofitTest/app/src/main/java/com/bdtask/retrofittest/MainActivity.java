package com.bdtask.retrofittest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bdtask.retrofittest.adpter.ProductListAdapter;
import com.bdtask.retrofittest.models.all_products.AllProductsModel;
import com.bdtask.retrofittest.models.all_products.ResponseObject;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //https://jsonplaceholder.typicode.com/todos/1
    //  https://reqres.in/api/users?page=2
    RecyclerView recyclerView;
    Button btnAll,btnIphone,btnOppo;
    ArrayList<ResponseObject> myListData=new ArrayList<>();
    RetrofitAPICall retrofitAPI;
    ProductListAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        btnIphone = (Button) findViewById(R.id.btnIphone);
        btnAll = (Button) findViewById(R.id.btnAll);
        btnOppo = (Button) findViewById(R.id.btnOpp);

        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getAllProducts();
            }
        });
        btnIphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLaptop();
            }
        });

        adapter = new ProductListAdapter(this,myListData);
        //recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
      //  recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dummyjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
         retrofitAPI = retrofit.create(RetrofitAPICall.class);

        getAllProducts();
    }




    public void getOppo(){
        Call<AllProductsModel> callAllProducts=retrofitAPI.getAllSmartPhone();
        callAllProducts.enqueue(new Callback<AllProductsModel>() {
            @Override
            public void onResponse(Call<AllProductsModel> call, Response<AllProductsModel> response) {

                Log.d("GetAllProducts",new Gson().toJson(response.body().getProducts()));
                myListData.addAll(response.body().getProducts());

                adapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<AllProductsModel> call, Throwable t) {

            }
        });
    }
    public void getLaptop(){
        Call<AllProductsModel> callAllProducts=retrofitAPI.getAllLaptop();
        callAllProducts.enqueue(new Callback<AllProductsModel>() {
            @Override
            public void onResponse(Call<AllProductsModel> call, Response<AllProductsModel> response) {
                myListData.clear();
                Log.d("GetAllProducts",new Gson().toJson(response.body().getProducts()));
                myListData.addAll(response.body().getProducts());

                adapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<AllProductsModel> call, Throwable t) {

            }
        });
    }
    public void getIPhone(){
        Call<AllProductsModel> callAllProducts=retrofitAPI.getAllSmartPhone();
        callAllProducts.enqueue(new Callback<AllProductsModel>() {
            @Override
            public void onResponse(Call<AllProductsModel> call, Response<AllProductsModel> response) {
                myListData.clear();
                Log.d("GetAllProducts",new Gson().toJson(response.body().getProducts()));
                myListData.addAll(response.body().getProducts());

                adapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<AllProductsModel> call, Throwable t) {

            }
        });
    }
    public void getAllProducts(){
        Call<AllProductsModel> callAllProducts=retrofitAPI.getAllSmartPhone();
        callAllProducts.enqueue(new Callback<AllProductsModel>() {
            @Override
            public void onResponse(Call<AllProductsModel> call, Response<AllProductsModel> response) {
                myListData.clear();
                Log.d("GetAllProducts",new Gson().toJson(response.body().getProducts()));
                myListData.addAll(response.body().getProducts());

                adapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<AllProductsModel> call, Throwable t) {

            }
        });
    }

}