package com.arashivision.arvbmg.util;

import com.arashivision.arvbmg.BMGConstants;
import com.arashivision.graphicpath.insmedia.InsMediaLibsLoader;
import com.arashivision.insbase.arlog.Log;

public class ARVBMGLibsLoader {
    public static final String TAG = "ins";
    public static boolean mLoaded;
    public static final Object mSyncObject = new Object();

    public static void load() {
        synchronized (mSyncObject) {
            if (!mLoaded) {
                Log.i("ins", "load arvbmg native libs");
                InsMediaLibsLoader.load();
                System.loadLibrary("apeg");
                System.loadLibrary("arvopencv4");
                System.loadLibrary(BMGConstants.TAG);
                mLoaded = true;
                Log.i("ins", "arvbmg native libs loaded");
            }
        }
    }
}
