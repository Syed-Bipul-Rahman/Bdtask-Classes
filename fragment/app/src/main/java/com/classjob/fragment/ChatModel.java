package com.classjob.fragment;

public class ChatModel {

    int image;
    String name, message,date;

    public ChatModel(int image, String name, String message, String date) {
        this.image = image;
        this.name = name;
        this.message = message;
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
