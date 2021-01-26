package com.arashivision.graphicpath.render.engine;

import com.arashivision.insbase.joml.Matrix4f;

public class PerspectiveCamera extends Camera {
    public PerspectiveCamera(float f2, float f3, String str) {
        this(createNativeWrap(f2, f3, str));
    }

    public static native long createNativeWrap(float f2, float f3, float f4, float f5, String str);

    public static native long createNativeWrap(float f2, float f3, String str);

    private native float[] nativeGetProjectionMatrix();

    public native float getAspect();

    public native float getEffectFov();

    public native float getFar();

    public native float getFov();

    public native float getNear();

    public Matrix4f getProjectionMatrix() {
        return new Matrix4f().set(nativeGetProjectionMatrix());
    }

    public native float getZoom();

    public native void setAspect(float f2);

    public native void setFar(float f2);

    public native void setFov(float f2);

    public native void setNear(float f2);

    public native void setZoom(float f2);

    public PerspectiveCamera(float f2, float f3, float f4, float f5, String str) {
        this(createNativeWrap(f2, f3, f4, f5, str));
    }

    public PerspectiveCamera(long j2) {
        super(j2, "PerspectiveCamera");
    }
}
