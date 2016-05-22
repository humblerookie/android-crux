package com.hr.crux.core.view;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hr.crux.core.model.GooglePlacesResult;

import java.util.List;

public interface MainActivityView extends MvpView {

    void showProgress();

    void showData(List<GooglePlacesResult> data);

    void showError();
}
