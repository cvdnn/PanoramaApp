package com.arashivision.onestream;

import android.util.Log;

public class NativePlayerLibLoader {
    public static final String TAG = "NativeLibsLoader";
    public static boolean mLoaded;
    public static final Object mSyncObject = new Object();

    public static void load() {
        synchronized (mSyncObject) {
            if (!mLoaded) {
                Log.i("NativeLibsLoader", "load insbase native libs");
                System.loadLibrary("c++_shared");
                System.loadLibrary("insbase2");
                System.loadLibrary("nativeplayer");
                mLoaded = true;
                Log.i("NativeLibsLoader", "export native libs loaded");
            }
        }
    }
}
