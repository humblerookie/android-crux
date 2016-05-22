package com.hr.crux.core.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GResult {

    @SerializedName("predictions")
    private List<GooglePlacesResult> predictions;

    @SerializedName("status")
    private String status;

    public List<GooglePlacesResult> getPredictions() {
        return predictions;
    }

    public void setPredictions(List<GooglePlacesResult> predictions) {
        this.predictions = predictions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
