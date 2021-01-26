package com.arashivision.insbase;

import android.util.Log;

public class NativeLibsLoader {
    public static final String TAG = "NativeLibsLoader";
    public static boolean mLoaded;
    public static final Object mSyncObject = new Object();

    public static void load() {
        synchronized (mSyncObject) {
            if (!mLoaded) {
                Log.i("NativeLibsLoader", "load insbase native libs");
                System.loadLibrary("c++_shared");
                System.loadLibrary("insbase");
                mLoaded = true;
                Log.i("NativeLibsLoader", "insbase native libs loaded");
            }
        }
    }
}
