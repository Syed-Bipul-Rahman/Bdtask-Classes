package com.bdtask.mvp_retrofit.ModelData;

import java.util.ArrayList;

public class AllProductsModel {
    int total;
    int skip;
    int limit;
   ArrayList<ResponseObject> products;

    public AllProductsModel(int total, int skip, int limit, ArrayList<ResponseObject> products) {
        this.total = total;
        this.skip = skip;
        this.limit = limit;
        this.products = products;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public ArrayList<ResponseObject> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ResponseObject> products) {
        this.products = products;
    }
}
