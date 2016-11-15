package com.hr.crux.core.view;

import com.hr.crux.core.model.GResult;
import com.hr.crux.core.model.RetrofitError;
import com.hr.crux.core.presenter.MainActivityPresenter;

import java.util.ArrayList;
import java.util.List;

public interface MainActivityView extends BaseView<MainActivityPresenter> {

    /**
     * Everything needed is provided by LceView
     * This interface is just for consistent name.
     * */

    void showLoading(boolean showLoading);

    void setData(List<GResult.GooglePlacesResult> data);

    void showContent();

    void showError(RetrofitError formattedError, boolean b);
}
