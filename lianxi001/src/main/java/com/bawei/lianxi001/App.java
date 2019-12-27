package com.bawei.lianxi001;

import android.app.Application;

public class App extends Application {
    public static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Thread.setDefaultUncaughtExceptionHandler(new BuHuo());
    }
}
