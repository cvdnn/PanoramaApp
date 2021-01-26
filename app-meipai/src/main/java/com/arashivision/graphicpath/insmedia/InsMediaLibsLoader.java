package com.arashivision.graphicpath.insmedia;

import com.arashivision.graphicpath.ui.GraphicView;
import com.arashivision.insbase.arlog.Log;

public class InsMediaLibsLoader {
    public static final String TAG = "ins";
    public static boolean mLoaded;
    public static final Object mSyncObject = new Object();

    public static void load() {
        synchronized (mSyncObject) {
            if (!mLoaded) {
                Log.i("ins", "load insmedia native libs");
                System.loadLibrary("c++_shared");
                System.loadLibrary("arypto");
                System.loadLibrary("asl");
                System.loadLibrary("turbojpeg");
                System.loadLibrary("insbase");
                System.loadLibrary("arffmpeg");
                System.loadLibrary("tbb");
                System.loadLibrary(GraphicView.TAG);
                mLoaded = true;
                Log.i("ins", "insmedia native libs loaded");
            }
        }
    }
}
