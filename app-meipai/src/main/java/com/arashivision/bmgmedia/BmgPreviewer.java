package com.arashivision.bmgmedia;

import android.view.Surface;

public class BmgPreviewer {
    static {
        NativeLibsLoader.load();
    }

    public BmgPreviewer() {
        nativeInit();
    }

    private native void nativeInit();

    private native void nativePlay(String str, Surface surface, long j2, long j3);

    public void play(String str, Surface surface, long j2, long j3) {
        nativePlay(str, surface, j2, j3);
    }
}
