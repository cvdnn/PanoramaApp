package com.arashivision.graphicpath.render.Stabilization;

import com.arashivision.graphicpath.render.RenderLibsLoader;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public abstract class GyroRawData extends NativeObjectRef {
    static {
        RenderLibsLoader.load();
    }

    public GyroRawData(long j2) {
        this(j2, "GyroRawData");
    }

    public abstract void InterruptIO() throws UnsupportedOperationException;

    public abstract boolean IsStream() throws UnsupportedOperationException;

    public abstract int Size() throws UnsupportedOperationException;

    public long getGyroTimeOffsetMs() {
        return nativeGetGyroTimeOffsetMS();
    }

    public int getGyroType() {
        return nativeGetGyroType();
    }

    public native long nativeGetGyroTimeOffsetMS();

    public native int nativeGetGyroType();

    public native void nativeSetGyroType(int i2);

    public void setGyroType(int i2) {
        nativeSetGyroType(i2);
    }

    public GyroRawData(long j2, String str) {
        super(j2, str);
    }
}
