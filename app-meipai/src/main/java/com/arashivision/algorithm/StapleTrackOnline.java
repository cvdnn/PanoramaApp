package com.arashivision.algorithm;

import android.util.Log;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.graphicpath.render.HybridRender;

public class StapleTrackOnline extends BMGNativeObjectRef {
    public static final String TAG = "StapleTrackOnline";
    public boolean mReleased;

    public StapleTrackOnline() {
        this(createNativeWrap());
        setRequireFreeManually();
    }

    public static native long createNativeWrap();

    private native void nativeDeinit(HybridRender hybridRender);

    private native void nativeEnableDebug();

    private native int nativeInit(HybridRender hybridRender, String str, String str2, String str3, int i2, int i3, float f2, float f3, float f4, String str4);

    private native int nativeInitTrack(HybridRender hybridRender, StapleTrackResult stapleTrackResult);

    private native int nativeTrack(HybridRender hybridRender, StapleTrackResult stapleTrackResult);

    public void enableDebug() {
        nativeEnableDebug();
    }

    public void finalize() throws Throwable {
        if (this.mReleased) {
            super.finalize();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(" not release before finalize ");
        throw new IllegalStateException(sb.toString());
    }

    public int init(HybridRender hybridRender, String str, String str2, String str3, int i2, int i3, float f2, float f3, float f4, String str4) {
        return nativeInit(hybridRender, str, str2, str3, i2, i3, f2, f3, f4, str4);
    }

    public int initTrack(HybridRender hybridRender, StapleTrackResult stapleTrackResult) {
        return nativeInitTrack(hybridRender, stapleTrackResult);
    }

    public void release(HybridRender hybridRender) {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(" release");
        Log.i("StapleTrackOnline", sb.toString());
        if (!this.mReleased) {
            nativeDeinit(hybridRender);
            free();
            this.mReleased = true;
        }
    }

    public int track(HybridRender hybridRender, StapleTrackResult stapleTrackResult) {
        return nativeTrack(hybridRender, stapleTrackResult);
    }

    public StapleTrackOnline(long j2) {
        super(j2, "StapleTrackOnline");
    }
}
