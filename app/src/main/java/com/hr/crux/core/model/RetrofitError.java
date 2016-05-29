package com.hr.crux.core.model;


import com.google.gson.JsonSyntaxException;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;

public class RetrofitError extends Throwable {

    private Type type;

    private int code;

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        NETWORK,
        HTTP,
        CONVERTER
    }

    public RetrofitError(Throwable throwable) {
        super(throwable);
        if (throwable instanceof IOException) {
            type = Type.NETWORK;
        } else if (throwable instanceof JsonSyntaxException) {
            type = Type.CONVERTER;
            JsonSyntaxException exception = (JsonSyntaxException) throwable;
            setMessage(exception.getMessage());
        } else {
            type = Type.HTTP;
            HttpException exception = (HttpException) throwable;
            setCode(exception.code());
            setMessage(exception.getMessage());

        }

    }


}
