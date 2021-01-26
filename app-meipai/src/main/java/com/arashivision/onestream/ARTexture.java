package com.arashivision.onestream;

import javax.microedition.khronos.egl.EGLContext;

public class ARTexture implements Cloneable {
    public static final float[] IDENTITY_MATRIX = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public EGLContext eglContext;
    public float[] gyroMatrix;
    public float[] matrix;
    public long nativeEglContext;
    public int textureId;
    public long timestampNsSysClock = -1;
    public Type type;

    public enum Type {
        GLES2_2D,
        GLES2_OES
    }

    public ARTexture(int i2, Type type2, float[] fArr, float[] fArr2, EGLContext eGLContext, long j2, long j3) {
        this.textureId = i2;
        this.type = type2;
        this.matrix = fArr;
        this.gyroMatrix = fArr2;
        this.eglContext = eGLContext;
        this.nativeEglContext = j2;
        this.timestampNsSysClock = j3;
    }

    public Object clone() {
        try {
            ARTexture aRTexture = (ARTexture) super.clone();
            aRTexture.textureId = this.textureId;
            aRTexture.type = this.type;
            aRTexture.matrix = (float[]) this.matrix.clone();
            aRTexture.gyroMatrix = (float[]) this.gyroMatrix.clone();
            aRTexture.eglContext = this.eglContext;
            aRTexture.nativeEglContext = this.nativeEglContext;
            aRTexture.timestampNsSysClock = this.timestampNsSysClock;
            return aRTexture;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
