package com.hr.crux.core.presenter;

import com.hr.crux.Application;
import com.hr.crux.BuildConfig;
import com.hr.crux.api.GooglePlacesResource;
import com.hr.crux.core.model.GResult;
import com.hr.crux.core.model.RetrofitError;
import com.hr.crux.core.view.MainActivityView;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivityPresenter extends BasePresenter<MainActivityView> {
    /**
     * Dagger Injections
     */

    @Inject
    Retrofit retrofit;


    public MainActivityPresenter(MainActivityView mainActivityView) {
        super(mainActivityView);
        Application.getComponentHost().getHttpComponent().inject(this);

    }

    public void onTextChanged(String s) {

        getView().showLoading(false);

        if (s.trim().length() > 0) {
            queryApi(s);
        } else {
            getView().setData(new ArrayList<>());
            getView().showContent();
        }
    }

    private void queryApi(String value) {

        GooglePlacesResource placesResource = retrofit.create(GooglePlacesResource.class);

        Observable<GResult> call = placesResource.getAutoCompletedPlaces(BuildConfig.GOOGLE_API_KEY, "establishment", value);


        call.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .map(result -> result.getPredictions())
                .subscribe(result -> {
                    if (isViewAttached()) {
                        getView().setData(result);
                        getView().showContent();
                    }
                }, error -> {

                    RetrofitError formattedError = new RetrofitError(error);

                    if (isViewAttached()) {
                        getView().showError(formattedError, false);
                    }

                });

    }
}
