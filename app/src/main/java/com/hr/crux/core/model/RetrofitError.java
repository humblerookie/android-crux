package com.hr.crux.core.model;


import com.google.gson.JsonSyntaxException;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;

public class RetrofitError extends Throwable {

    public Type type;

    public int code;

    public String message;

    @Override
    public String getMessage() {
        return message;
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
            this.message = exception.getMessage();
        } else {
            type = Type.HTTP;
            HttpException exception = (HttpException) throwable;
            this.code = exception.code();
            this.message = exception.getMessage();

        }

    }


}
