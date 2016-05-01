package com.hr.crux.loaders;


import com.hr.crux.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppUtils.class})
public interface AppUtilComponents {

    void inject(MainActivity activity);

}
