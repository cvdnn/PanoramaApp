package com.arashivision.insbase.sys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.arashivision.insbase.NativeLibsLoader;
import java.io.File;

public class SysInfo {
    public static final String TAG = "ins";
    @SuppressLint({"StaticFieldLeak"})
    public static Context mAppContext;
    public static final Object mSyncObject = new Object();

    static {
        NativeLibsLoader.load();
    }

    public static String getInfo(String str) {
        String str2 = "";
        String str3 = "ins";
        if (mAppContext == null) {
            Log.e(str3, "SysInfo not init yet");
            return str2;
        } else if (str.equals("DataDirectory")) {
            return mAppContext.getFilesDir().getAbsolutePath();
        } else {
            if (str.equals("ExternalStorage")) {
                return Environment.getExternalStorageDirectory().getAbsolutePath();
            }
            if (str.equals("CacheDirectory")) {
                File externalCacheDir = mAppContext.getExternalCacheDir();
                if (externalCacheDir == null || externalCacheDir.isDirectory()) {
                    mAppContext.getCacheDir();
                }
                return externalCacheDir.getAbsolutePath();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("unknown info item: ");
            sb.append(str);
            Log.e(str3, sb.toString());
            return str2;
        }
    }

    public static void init(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (mSyncObject) {
                if (mAppContext == null) {
                    mAppContext = applicationContext;
                    nativeInit();
                    return;
                }
                return;
            }
        }
        throw new NullPointerException("context should not be null");
    }

    public static native void nativeInit();
}
