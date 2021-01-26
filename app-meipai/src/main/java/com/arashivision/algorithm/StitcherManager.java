package com.arashivision.algorithm;

import android.content.Context;
import com.arashivision.arvbmg.util.ARVBMGLibsLoader;

public class StitcherManager {
    public static final String TAG = "StitcherManager";
    public Context mContext;
    public long mNativeInstance;
    public boolean mRelease;

    public static class StitcherType {
        public static final int CALIB = 3;
        public static final int DIRECT = 1;
        public static final int MAKER = 0;
        public static final int MAKER_DIRECT = 2;
    }

    static {
        ARVBMGLibsLoader.load();
    }

    public StitcherManager(Context context) {
        this.mContext = context;
        nativeCreate();
    }

    private native void nativeCreate();

    private native String nativeGetOffset();

    private native void nativeInitParams(String str, int i2, int i3);

    private native void nativeRelease();

    private native void nativeSetFixedOption(boolean z, boolean z2, boolean z3);

    private native void nativeSetImage(String[] strArr);

    private native String nativeSetStitcherType(int i2);

    private void release() {
        if (!this.mRelease) {
            nativeRelease();
            this.mRelease = true;
        }
    }

    public void finalize() throws Throwable {
        release();
        super.finalize();
    }

    public String getOffset() {
        return nativeGetOffset();
    }

    public void initParams(String str, int i2, int i3) {
        nativeInitParams(str, i2, i3);
    }

    public void setFixedOption(boolean z, boolean z2, boolean z3) {
        nativeSetFixedOption(z, z2, z3);
    }

    public void setImage(String[] strArr) {
        nativeSetImage(strArr);
    }

    public void setStitcherType(int i2) {
        nativeSetStitcherType(i2);
    }
}
