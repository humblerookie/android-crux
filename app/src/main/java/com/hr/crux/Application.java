package com.hr.crux;

import com.hr.crux.loaders.AppUtilComponents;
import com.hr.crux.loaders.AppUtils;
import com.hr.crux.loaders.DaggerAppUtilComponents;

public class Application extends android.app.Application {

    private static Application application;

    AppUtilComponents appUtilComponents;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        appUtilComponents = DaggerAppUtilComponents.builder().appUtils(new AppUtils()).build();
    }

    public static Application getInstance() {
        return application;
    }

    public AppUtilComponents getComponent() {
        return appUtilComponents;
    }
}
