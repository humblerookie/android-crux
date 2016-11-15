package com.hr.crux.core.presenter;

import com.hr.crux.core.view.BaseView;

import java.lang.ref.WeakReference;

/**
 * Created by bariski on 11/15/2016.
 */

public abstract class BasePresenter<T extends BaseView> {

    WeakReference<T> viewWeakReference;

    BasePresenter(T view) {
        this.viewWeakReference = new WeakReference<>(view);
    }
    protected T getView() {
        return viewWeakReference.get();
    }

    protected boolean isViewAttached() {
        return viewWeakReference.get() != null;
    }
}
