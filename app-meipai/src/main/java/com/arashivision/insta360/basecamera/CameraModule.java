package com.arashivision.insta360.basecamera;

import android.app.Application;
import android.content.Context;

public class CameraModule {
    public static Application OooO00o;

    public static Application getApplication() {
        return OooO00o;
    }

    public static Context getApplicationContext() {
        return OooO00o.getApplicationContext();
    }

    public static void init(Application application) {
        OooO00o = application;
    }
}
