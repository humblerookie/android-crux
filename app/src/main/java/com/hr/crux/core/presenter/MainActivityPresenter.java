package com.hr.crux.core.presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hr.crux.Application;
import com.hr.crux.BuildConfig;
import com.hr.crux.api.GooglePlacesResource;
import com.hr.crux.core.model.GResult;
import com.hr.crux.core.view.MainActivityView;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivityPresenter extends MvpBasePresenter<MainActivityView> {
    /**
     * Dagger Injections
     */

    @Inject
    Retrofit retrofit;

    public MainActivityPresenter() {

        Application.getComponentHost().getHttpComponent().inject(this);

    }

    public void onTextChanged(String s) {

        queryApi(s);
    }

    private void queryApi(String value) {

        GooglePlacesResource placesResource = retrofit.create(GooglePlacesResource.class);


        Observable<GResult> call = placesResource.getAutoCompletedPlaces(BuildConfig.GOOGLE_API_KEY, "establishment", value);

        call.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .map(result -> result.getPredictions())
                .doOnError(throwable -> {
                    if (throwable instanceof HttpException) {
                        if (isViewAttached()) {

                        }
                    }
                })
                .subscribe(result -> {

                    if (isViewAttached()) {
                        getView().showData(result);
                    }
                });

    }
}
