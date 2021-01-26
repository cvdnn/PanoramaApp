package com.deepai.library.app;

import android.app.Application;

public class BaseApp extends Application {
    private static BaseApp application;

    public static BaseApp getInstance() {
        return application;
    }

    public void onCreate() {
        super.onCreate();
        application = this;
    }
}
