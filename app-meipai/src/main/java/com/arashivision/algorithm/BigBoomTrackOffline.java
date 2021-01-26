package com.arashivision.algorithm;

import android.util.Log;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class BigBoomTrackOffline extends BMGNativeObjectRef {
    public static final String TAG = "StapleTrackOnline";
    public boolean mReleased;

    public BigBoomTrackOffline() {
        this(createNativeWrap());
        setRequireFreeManually();
    }

    public static native long createNativeWrap();

    private native void nativeEnableDebug();

    private native int nativeInit(String str, String str2, String str3);

    private native void nativeRelease();

    private native int nativeTrack(String str);

    public static native int nativeTrackOnce(String str, String str2, String str3, String str4, float[] fArr);

    public static int trackOnce(String str, String str2, String str3, String str4, float[] fArr) {
        return nativeTrackOnce(str, str2, str3, str4, fArr);
    }

    public void enableDebug() {
        nativeEnableDebug();
    }

    public void finalize() throws Throwable {
        if (this.mReleased) {
            release();
            super.finalize();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(" not release before finalize ");
        throw new IllegalStateException(sb.toString());
    }

    public int init(String str, String str2, String str3) {
        return nativeInit(str, str2, str3);
    }

    public void release() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(" release");
        Log.i("StapleTrackOnline", sb.toString());
        if (!this.mReleased) {
            nativeRelease();
            free();
            this.mReleased = true;
        }
    }

    public int track(String str) {
        return nativeTrack(str);
    }

    public BigBoomTrackOffline(long j2) {
        super(j2, "BigBoomTrackOffline");
    }
}
