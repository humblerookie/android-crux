package com.hr.crux.core.view;

import com.hr.crux.core.presenter.BasePresenter;

/**
 * Created by bariski on 11/15/2016.
 */

public interface BaseView<T extends BasePresenter>{

    T getPresenter();

    void setPresenter(T presenter);

}
