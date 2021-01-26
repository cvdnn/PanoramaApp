package com.arashivision.arvbmg.render.gyro;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.insbase.nativeref.NativeBuffer;

public class ResolveGyroOptions extends BMGNativeObjectRef {

    public static class StabType {
        public static final int INS_STAB_BULLETTIME = 5;
        public static final int INS_STAB_BULLETTIME_OFFLINE = 6;
        public static final int INS_STAB_FREE_FOOTAGE = 4;
        public static final int INS_STAB_FREE_FULL_DIRECTIONAL = 3;
        public static final int INS_STAB_FULL_DIRECTIONAL = 2;
        public static final int INS_STAB_OFF = -1;
        public static final int INS_STAB_STILL = 0;
        public static final int INS_STAB_Z_DIRECTIONAL = 1;
    }

    public ResolveGyroOptions() {
        this(createNativeWrap());
    }

    public static long createNativeWrap() {
        return nativeCreateNativeWrap();
    }

    public static native long nativeCreateNativeWrap();

    private native void nativeSetDetectStabType(boolean z);

    private native void nativeSetLoad(boolean z);

    private native void nativeSetNativeBuffer(NativeBuffer nativeBuffer);

    private native void nativeSetPreferredStabType(int i2);

    private native void nativeSetReadBatchCount(long j2);

    private native void nativeSetReadInStreamMode(boolean z);

    private native long nativeSetTimestampRange(double d2, double d3);

    public void setDetectStabType(boolean z) {
        nativeSetDetectStabType(z);
    }

    public void setLoad(boolean z) {
        nativeSetLoad(z);
    }

    public void setNativeBuffer(NativeBuffer nativeBuffer) {
        nativeSetNativeBuffer(nativeBuffer);
    }

    public void setPreferredStabType(int i2) {
        nativeSetPreferredStabType(i2);
    }

    public void setReadBatchCount(long j2) {
        nativeSetReadBatchCount(j2);
    }

    public void setReadInStreamMode(boolean z) {
        nativeSetReadInStreamMode(z);
    }

    public void setTimestampRange(double d2, double d3) {
        nativeSetTimestampRange(d2, d3);
    }

    public ResolveGyroOptions(long j2) {
        super(j2, "ResolveGyroOptions");
    }
}
