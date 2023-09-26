package com.bdtask.retrofittest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.bdtask.retrofittest.models.all_products.AllProductsModel;
import com.bdtask.retrofittest.models.all_products.ResponseObject;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Second extends AppCompatActivity {
    RetrofitAPICall retrofitAPI;
    String _id="";
    String productTitle="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
         _id=intent.getStringExtra("_id");
         Log.d("_id",_id);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dummyjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitAPI = retrofit.create(RetrofitAPICall.class);
        getDetails();
    }
    public void getDetails(){
        Log.d("uurl","products/"+_id);
        Call<ResponseObject> callAllProducts=retrofitAPI.getPrductDetails("products/"+_id);
        callAllProducts.enqueue(new Callback<ResponseObject>() {
            @Override
            public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {
                productTitle=response.body().getTitle();
                //Log.d("GetAllProducts",new Gson().toJson(response.body().getTitle()));


            }

            @Override
            public void onFailure(Call<ResponseObject> call, Throwable t) {

            }
        });
    }
}