package com.classjob.retrofitwithpicasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("products")
    Call<ProductsResponse> getAllProducts();

}
