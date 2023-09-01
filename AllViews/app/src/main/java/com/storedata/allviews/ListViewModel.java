package com.storedata.allviews;

public class ListViewModel {

    private int imageResourceId;
    private String text1;
    private String text2;

    public ListViewModel(int imageResourceId, String text1, String text2) {
        this.imageResourceId = imageResourceId;
        this.text1 = text1;
        this.text2 = text2;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
}
