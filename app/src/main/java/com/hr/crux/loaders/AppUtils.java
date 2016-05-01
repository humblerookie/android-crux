package com.hr.crux.loaders;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.hr.crux.Application;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppUtils {

    @Provides
    @Singleton
    public AppUtils getInstance() {
        return new AppUtils();
    }

    public List<ApplicationInfo> getApps() {
        final PackageManager pm = Application.getInstance().getPackageManager();
        return pm.getInstalledApplications(PackageManager.GET_META_DATA);

    }
}
