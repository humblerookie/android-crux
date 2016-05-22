package com.hr.crux;

import com.hr.crux.components.DaggerHttpComponent;
import com.hr.crux.module.HttpModule;
import com.hr.crux.util.ComponentHost;


public class Application extends android.app.Application {

    private static Application application;

    private static ComponentHost componentHost;


    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        componentHost = new ComponentHost();
        componentHost.setHttpComponent(DaggerHttpComponent.builder().httpModule(new HttpModule()).build());

    }


    public static Application getInstance() {
        return application;
    }


    public static ComponentHost getComponentHost() {
        return componentHost;
    }

}
