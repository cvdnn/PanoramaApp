package com.arashivision.graphicpath.render.source;

import com.arashivision.insbase.nativeref.NativeBuffer;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public class ResolveGyroOptions extends NativeObjectRef {

    public static class FilterInstanceType {
        public static final int AUTO_DECTED = 0;
        public static final int OFFLINE_FIR = 3;
        public static final int OFFLINE_FIR_ORIENT = 3;
        public static final int OFFLINE_FIR_VIEWPORT = 5;
        public static final int ONLINE_KF = 2;
        public static final int ONLINE_KF_ORIENT = 2;
        public static final int ONLINE_KF_VIEWPORT = 4;
        public static final int ONLINE_SLIDINGWINDOW = 1;
        public static final int ONLINE_SLIDINGWINDOW_NONLINEAR = 1;
        public static final int ONLINE_SLIDINGWINDOW_ORIENT = 6;
    }

    public ResolveGyroOptions() {
        this(createNativeWrap());
    }

    public static long createNativeWrap() {
        return nativeCreateNativeWrap();
    }

    public static native long nativeCreateNativeWrap();

    private native void nativeSetDetectFilterType(boolean z);

    private native void nativeSetDetectStabType(boolean z);

    private native void nativeSetLoad(boolean z);

    private native void nativeSetNativeBuffer(NativeBuffer nativeBuffer);

    private native void nativeSetPreferredFilterInstanceType(int i2);

    private native void nativeSetPreferredFilterType(int i2);

    private native void nativeSetPreferredStabType(int i2);

    private native void nativeSetReadBatchCount(long j2);

    private native void nativeSetReadInStreamMode(boolean z);

    private native long nativeSetTimestampRange(double d2, double d3);

    public void setDetectFilterType(boolean z) {
        nativeSetDetectFilterType(z);
    }

    public void setDetectStabType(boolean z) {
        nativeSetDetectStabType(z);
    }

    public void setLoad(boolean z) {
        nativeSetLoad(z);
    }

    public void setNativeBuffer(NativeBuffer nativeBuffer) {
        nativeSetNativeBuffer(nativeBuffer);
    }

    public void setPreferredFilterInstanceType(int i2) {
        nativeSetPreferredFilterInstanceType(i2);
    }

    public void setPreferredFilterType(int i2) {
        nativeSetPreferredFilterType(i2);
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
