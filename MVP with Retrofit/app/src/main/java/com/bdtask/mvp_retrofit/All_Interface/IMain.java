package com.bdtask.mvp_retrofit.All_Interface;

import com.bdtask.mvp_retrofit.ModelData.AllProductsModel;

public interface IMain {

    interface mainView{

        public void allProductList(AllProductsModel allProductsModel);

        void hideLoading();
        void showLoading();
        void showError();
    }
    interface mainPresenter{
        public void getAllData();
    }
}
