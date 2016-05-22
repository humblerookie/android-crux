package com.hr.crux.api;

import com.hr.crux.core.model.GResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface GooglePlacesResource {

    @GET("autocomplete/json")
    Observable<GResult> getAutoCompletedPlaces(@Query("key") String key, @Query("type") String type, @Query("input") String query);
}
