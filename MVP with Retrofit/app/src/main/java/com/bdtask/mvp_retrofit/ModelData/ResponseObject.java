package com.bdtask.mvp_retrofit.ModelData;

import java.util.ArrayList;

public class ResponseObject {

    private int id;
    private int price;
    private int stock;
    private double discountPercentage;
    private double rating;
    private String title;
    private String description;
    private String brand;
    private String category;
    private String thumbnail;
    private ArrayList<String> images;

    public ResponseObject(int id, int price, int stock, double discountPercentage, double rating, String title, String description, String brand, String category, String thumbnail, ArrayList<String> images) {
        this.id = id;
        this.price = price;
        this.stock = stock;
        this.discountPercentage = discountPercentage;
        this.rating = rating;
        this.title = title;
        this.description = description;
        this.brand = brand;
        this.category = category;
        this.thumbnail = thumbnail;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }
}
