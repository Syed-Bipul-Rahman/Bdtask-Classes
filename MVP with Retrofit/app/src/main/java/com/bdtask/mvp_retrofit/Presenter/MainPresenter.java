package com.bdtask.mvp_retrofit.Presenter;

import com.bdtask.mvp_retrofit.All_Interface.IMain;
import com.bdtask.mvp_retrofit.ModelData.AllProductsModel;
import com.bdtask.mvp_retrofit.RetrofitApi.ApiClient;
import com.bdtask.mvp_retrofit.RetrofitApi.IRetrofitApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements IMain.mainPresenter {

    IMain.mainView mainView ;
    public MainPresenter (IMain.mainView mainView) {
        this.mainView=mainView;
        mainView.showLoading();
    }


    @Override
    public void getAllData() {


        IRetrofitApi retrofitApi = ApiClient.getApiClient().create(IRetrofitApi.class);
        Call<AllProductsModel> call = retrofitApi.getAllSmartPhone();
        call.enqueue(new Callback<AllProductsModel>() {
            @Override
            public void onResponse(Call<AllProductsModel> call, Response<AllProductsModel> response) {

                mainView.allProductList(response.body());
                mainView.hideLoading();
                /*
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    ContactListInfo contactListInfo = response.body();
                    view.onGetResult(contactListInfo);
                } else if (response.code() == 401) {

                    view.hideLoading();
                    view.tokenError();
                }*/
            }

            @Override
            public void onFailure(Call<AllProductsModel> call, Throwable t) {

              /*  view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());*/
            }
        });

    }
}
