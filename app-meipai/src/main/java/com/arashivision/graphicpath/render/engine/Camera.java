package com.arashivision.graphicpath.render.engine;

import com.arashivision.insbase.joml.Matrix4f;

public abstract class Camera extends Object3D {
    public Camera(long j2, String str) {
        super(j2, str);
    }

    public Matrix4f getInverseWorldMatrix() {
        return new Matrix4f().set(nativeGetInverseWorldMatrix());
    }

    public abstract Matrix4f getProjectionMatrix();

    public native float[] nativeGetInverseWorldMatrix();

    public Camera(long j2) {
        this(j2, "Camera");
    }
}
