package com.bdtask.retrofittest;

import android.net.Uri;

import com.bdtask.retrofittest.models.all_products.AllProductsModel;
import com.bdtask.retrofittest.models.all_products.ResponseObject;

import java.net.URL;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitAPICall {
    // as we are making a get request specifying annotation as get and adding a url end point to it.
    @GET("products/1")
    Call<ResponseObject> getData();


    @GET("products/category/smartphones")
    Call<AllProductsModel> getAllSmartPhone();


    @GET("products/search?q=Laptop")
    Call<AllProductsModel> getAllLaptop();


    @GET()
    Call<ResponseObject> getPrductDetails(@Url String url);


}
