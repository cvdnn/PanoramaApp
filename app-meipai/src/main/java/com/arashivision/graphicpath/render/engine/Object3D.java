package com.arashivision.graphicpath.render.engine;

import com.arashivision.graphicpath.render.RenderLibsLoader;
import com.arashivision.graphicpath.render.util.MathDataConverter;
import com.arashivision.insbase.joml.Matrix4f;
import com.arashivision.insbase.joml.Quaternionf;
import com.arashivision.insbase.joml.Vector3f;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public class Object3D extends NativeObjectRef {
    static {
        RenderLibsLoader.load();
    }

    public Object3D(String str) {
        super(createNativeWrap(str), str);
    }

    public static native long createNativeWrap(String str);

    private native void nativeApplyMatrix(float[] fArr);

    private native float[] nativeGetLocalMatrix();

    private native float[] nativeGetPosition();

    private native float[] nativeGetQuaternion();

    private native float[] nativeGetScale();

    private native float[] nativeGetWorldMatrix();

    private native void nativeLookAt(float f2, float f3, float f4);

    private native void nativeRotateOnWorldAxis(float f2, float f3, float f4, float f5);

    private native void nativeSetPosition(float f2, float f3, float f4);

    private native void nativeSetTransformMatrix(float[] fArr);

    private native void nativeTranslate(float f2, float f3, float f4);

    private native void rotate(float f2, float f3, float f4, float f5);

    public void applyMatrix(Matrix4f matrix4f) {
        float[] fArr = new float[16];
        matrix4f.get(fArr);
        nativeApplyMatrix(fArr);
    }

    public native void calculateLocalMatrix();

    public native void calculateWorldMatrix();

    public native float getDistance();

    public Matrix4f getLocalMatrix() {
        return new Matrix4f().set(nativeGetLocalMatrix());
    }

    public Vector3f getPosition() {
        float[] nativeGetPosition = nativeGetPosition();
        return new Vector3f(nativeGetPosition[0], nativeGetPosition[1], nativeGetPosition[2]);
    }

    public Quaternionf getQuaternion() {
        return MathDataConverter.FloatArrayToQuaternion(nativeGetQuaternion());
    }

    public Vector3f getScale() {
        float[] nativeGetScale = nativeGetScale();
        return new Vector3f(nativeGetScale[0], nativeGetScale[1], nativeGetScale[2]);
    }

    public Matrix4f getWorldMatrix() {
        return new Matrix4f().set(nativeGetWorldMatrix());
    }

    public native boolean isCamera();

    public native boolean isRenderObject();

    public void lookAt(Vector3f vector3f) {
        nativeLookAt(vector3f.x, vector3f.y, vector3f.z);
    }

    public native void resetTransform();

    public void rotate(Vector3f vector3f, float f2) {
        rotate(vector3f.x, vector3f.y, vector3f.z, f2);
    }

    public void rotateOnWorldAxis(Vector3f vector3f, float f2) {
        nativeRotateOnWorldAxis(vector3f.x, vector3f.y, vector3f.z, f2);
    }

    public native void rotateX(float f2);

    public native void rotateY(float f2);

    public native void rotateZ(float f2);

    public void setPosition(Vector3f vector3f) {
        nativeSetPosition(vector3f.x, vector3f.y, vector3f.z);
    }

    public native void setScale(float f2);

    public native void setScale(float f2, float f3, float f4);

    public void setTransformMatrix(Matrix4f matrix4f) {
        float[] fArr = new float[16];
        matrix4f.get(fArr);
        nativeSetTransformMatrix(fArr);
    }

    public void translate(Vector3f vector3f) {
        nativeTranslate(vector3f.x, vector3f.y, vector3f.z);
    }

    public native void translateX(float f2);

    public native void translateY(float f2);

    public native void translateZ(float f2);

    public Object3D(long j2) {
        super(j2, "Object3D");
    }

    public Object3D(long j2, String str) {
        super(j2, str);
    }
}
