package com.arashivision.graphicpath.render.util;

import com.arashivision.graphicpath.render.RenderLibsLoader;
import com.arashivision.insbase.joml.Vector3f;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public abstract class Stabilizer extends NativeObjectRef {

    public static class Direction {
        public static final int BACK = 2;
        public static final int BOTTOM = 3;
        public static final int FRONT = 0;
        public static final int LEFT = 4;
        public static final int RIGHT = 5;
        public static final int TOP = 1;
    }

    static {
        RenderLibsLoader.load();
    }

    public Stabilizer(long j2) {
        this(j2, "Stabilizer");
    }

    public static Stabilizer createStabilizerWithNativeWrap(long j2) {
        if (j2 == 0) {
            return null;
        }
        if (isSequenceStabilizer(j2)) {
            return new SequenceStabilizer(j2);
        }
        return new SingleGyroStabilizer(j2);
    }

    public static native boolean isSequenceStabilizer(long j2);

    private native void nativeGetEulerAnglesForRenderCamera(double d2, int i2, float[] fArr);

    public Vector3f getEulerAnglesForRenderCamera(double d2, int i2) {
        float[] fArr = new float[3];
        nativeGetEulerAnglesForRenderCamera(d2, i2, fArr);
        return new Vector3f(fArr[0], fArr[1], fArr[2]);
    }

    public native int getStabType();

    public native boolean loadData();

    public native boolean loadRealTimeData();

    public native void setStabType(int i2);

    public boolean startLoadDataBase() {
        return loadData();
    }

    public void updateStabTypeBase(int i2) {
        setStabType(i2);
    }

    public Stabilizer(long j2, String str) {
        super(j2, str);
    }
}
