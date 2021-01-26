package com.arashivision.bmgmedia.utils;

import android.util.Log;

public class VideoTexture {
    public long mNativeInstance = nativeInit();
    public boolean mReleased;

    private native long nativeInit();

    private native void nativeRelease();

    private native boolean nativeUpdateTexture();

    public void finalize() throws Throwable {
        if (!this.mReleased) {
            Log.e("AVideoTexture", "MUST release manually");
            release();
        }
        super.finalize();
    }

    public void release() {
        nativeRelease();
        this.mNativeInstance = 0;
    }

    public boolean updateTexture() {
        return nativeUpdateTexture();
    }
}
