package com.hr.crux.core.model;

import com.google.gson.annotations.SerializedName;

public class APIError {

    @SerializedName("statusCode")
    public int statusCode;

    @SerializedName("message")
    public String message;

    public APIError() {
    }

 
}