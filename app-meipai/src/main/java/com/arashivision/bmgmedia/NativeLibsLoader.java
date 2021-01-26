package com.arashivision.bmgmedia;

import android.util.Log;
import com.arashivision.graphicpath.render.RenderLibsLoader;

public class NativeLibsLoader {
    public static final String TAG = "BmgMediaLoader";
    public static boolean mLoaded;
    public static final Object mSyncObject = new Object();

    public static void load() {
        synchronized (mSyncObject) {
            if (!mLoaded) {
                Log.i(TAG, "load bmgmedia native libs");
                RenderLibsLoader.load();
                System.loadLibrary("bmgmedia");
                mLoaded = true;
                Log.i(TAG, "bmgmedia native libs loaded");
            }
        }
    }
}
