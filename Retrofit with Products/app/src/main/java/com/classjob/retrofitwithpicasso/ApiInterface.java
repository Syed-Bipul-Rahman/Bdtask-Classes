package com.classjob.retrofitwithpicasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiInterface {

    @GET("products")
    Call<ProductsResponse> getAllProducts();

    @GET()
    Call<Product> getSingleProducts(@Url String url);


}
