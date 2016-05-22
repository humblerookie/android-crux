package com.hr.crux.components;


import com.hr.crux.core.presenter.MainActivityPresenter;
import com.hr.crux.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {HttpModule.class})
public interface HttpComponent {

    void inject(MainActivityPresenter activityPresenter);

}
