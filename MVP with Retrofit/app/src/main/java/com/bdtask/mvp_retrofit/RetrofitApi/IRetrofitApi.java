package com.bdtask.mvp_retrofit.RetrofitApi;

import com.bdtask.mvp_retrofit.ModelData.AllProductsModel;
import com.bdtask.mvp_retrofit.ModelData.ResponseObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IRetrofitApi {

    @GET("products/1")
    Call<ResponseObject> getData();


    @GET("products/category/smartphones")
    Call<AllProductsModel> getAllSmartPhone();
}
