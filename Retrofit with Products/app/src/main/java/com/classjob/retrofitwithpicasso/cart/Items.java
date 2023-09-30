package com.classjob.retrofitwithpicasso.cart;

public class Items {

    private String productImage;
    private String productid;
    private String brandName;
    private String productPrice;
    private String trxid;
    private String productName;

    public Items(String productImage, String productid, String brandName, String productPrice, String trxid, String productName) {
        this.productImage = productImage;
        this.productid = productid;
        this.brandName = brandName;
        this.productPrice = productPrice;
        this.trxid = trxid;
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getTrxid() {
        return trxid;
    }

    public void setTrxid(String trxid) {
        this.trxid = trxid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
