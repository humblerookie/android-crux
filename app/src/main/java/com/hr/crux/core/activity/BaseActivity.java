package com.hr.crux.core.activity;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

public abstract class BaseActivity<V extends MvpView, P extends MvpPresenter<V>> extends MvpActivity {

    public boolean isAlive() {
        return !isFinishing() && !isDestroyed();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
