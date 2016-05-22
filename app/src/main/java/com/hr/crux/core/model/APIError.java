package com.hr.crux.core.model;

import com.google.gson.annotations.SerializedName;

public class APIError {

    @SerializedName("statusCode")
    private int statusCode;

    @SerializedName("message")
    private String message;

    public APIError() {
    }

    public int status() {
        return statusCode;
    }

    public String message() {
        return message;
    }
}