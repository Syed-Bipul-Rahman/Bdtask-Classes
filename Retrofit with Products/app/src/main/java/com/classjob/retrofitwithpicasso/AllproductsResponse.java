package com.classjob.retrofitwithpicasso;

import java.util.ArrayList;

public class AllproductsResponse {
    ArrayList<Product> products;
    int total;

    public AllproductsResponse(ArrayList<Product> products, int total) {
        this.products = products;
        this.total = total;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
