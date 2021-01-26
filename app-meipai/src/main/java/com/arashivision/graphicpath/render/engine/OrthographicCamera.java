package com.arashivision.graphicpath.render.engine;

import com.arashivision.insbase.joml.Matrix4f;

public class OrthographicCamera extends Camera {
    public OrthographicCamera() {
        this(createNativeWrap());
    }

    public static native long createNativeWrap();

    public static native long createNativeWrap(float f2, float f3, float f4, float f5, float f6, float f7, String str);

    public static native long createNativeWrap(float f2, float f3, float f4, float f5, String str);

    private native float[] nativeGetProjectionMatrix();

    public native float getBottom();

    public native float getFar();

    public native float getLeft();

    public native float getNear();

    public Matrix4f getProjectionMatrix() {
        return new Matrix4f().set(nativeGetProjectionMatrix());
    }

    public native float getRight();

    public native float getTop();

    public native float getZoom();

    public native void setBottom(float f2);

    public native void setFar(float f2);

    public native void setLeft(float f2);

    public native void setNear(float f2);

    public native void setRight(float f2);

    public native void setTop(float f2);

    public native void setZoom(float f2);

    public OrthographicCamera(float f2, float f3, float f4, float f5, String str) {
        this(createNativeWrap(f2, f3, f4, f5, str));
    }

    public OrthographicCamera(float f2, float f3, float f4, float f5, float f6, float f7, String str) {
        this(createNativeWrap(f2, f3, f4, f5, f6, f7, str));
    }

    public OrthographicCamera(long j2) {
        super(j2, "OrthographicCamera");
    }
}
