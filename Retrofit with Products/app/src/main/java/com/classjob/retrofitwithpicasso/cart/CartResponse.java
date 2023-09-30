package com.classjob.retrofitwithpicasso.cart;

import java.util.List;

public class CartResponse {
    private List<Items> data;
    private String message;
    private String status;

    public CartResponse(List<Items> data, String message, String status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public List<Items> getData() {
        return data;
    }

    public void setData(List<Items> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
