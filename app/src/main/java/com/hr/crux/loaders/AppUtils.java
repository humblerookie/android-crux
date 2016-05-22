package com.hr.crux.loaders;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.hr.crux.Application;

import java.util.List;


public class AppUtils {

    private static Application application;

    AppUtils(Application context) {
        application = context;
    }

    public static AppUtils getInstance() {
        return new AppUtils(application);
    }

    public List<ApplicationInfo> getApps() {
        final PackageManager pm = application.getPackageManager();
        return pm.getInstalledApplications(PackageManager.GET_META_DATA);

    }
}
