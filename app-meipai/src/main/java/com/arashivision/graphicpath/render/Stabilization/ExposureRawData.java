package com.arashivision.graphicpath.render.Stabilization;

import com.arashivision.graphicpath.render.RenderLibsLoader;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public abstract class ExposureRawData extends NativeObjectRef {
    static {
        RenderLibsLoader.load();
    }

    public ExposureRawData(long j2) {
        this(j2, "GyroRawData");
    }

    public long GetExposureTimeOffsetMs() {
        return nativeGetExposureTimeOffsetMs();
    }

    public abstract double GetShutterSpeed(long j2);

    public abstract void InterruptIO();

    public abstract int Size();

    public native long nativeGetExposureTimeOffsetMs();

    public ExposureRawData(long j2, String str) {
        super(j2, str);
    }
}
