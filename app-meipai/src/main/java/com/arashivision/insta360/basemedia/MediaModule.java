package com.arashivision.insta360.basemedia;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import java.io.File;

public class MediaModule {
    public static Application IL1Iii;
    public static String ILil;

    public static Application getApplication() {
        return IL1Iii;
    }

    public static Context getApplicationContext() {
        return IL1Iii.getApplicationContext();
    }

    public static String getCacheFolder() {
        return ILil;
    }

    public static void init(Application application) {
        IL1Iii = application;
        if (ILil == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
            sb.append(File.separator);
            sb.append(MediaModule.class.getSimpleName());
            sb.append(File.separator);
            ILil = sb.toString();
        }
    }

    public static void setCachePath(String str) {
        ILil = str;
    }
}
