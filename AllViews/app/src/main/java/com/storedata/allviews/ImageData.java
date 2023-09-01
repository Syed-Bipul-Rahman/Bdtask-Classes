package com.storedata.allviews;

public class ImageData {
    private int imageDrawableId;
    private String name;
    private String description;

    public ImageData(int imageDrawableId, String name, String description) {
        this.imageDrawableId = imageDrawableId;
        this.name = name;
        this.description = description;
    }

    public int getImageDrawableId() {
        return imageDrawableId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
