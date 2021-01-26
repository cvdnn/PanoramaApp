package com.arashivision.graphicpath.render.base;

import com.arashivision.insbase.joml.Vector2f;
import com.arashivision.insbase.joml.Vector3f;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public class BaseCameraController extends NativeObjectRef {

    public static class Mode {
        public static final int GESTURE_ALONE = 1;
        public static final int GESTURE_MERGE = 0;
    }

    public BaseCameraController() {
        this(0);
    }

    public static native long createNativeWrap();

    private native void nativeApplyPointRotation(float f2, float f3, float f4, float f5, float f6, float f7);

    private native void nativeMoveLookAt(float f2, float f3, float f4);

    private native boolean nativeScreenToSpherePoint(float f2, float f3, float[] fArr);

    private native void nativeSetProjection(float f2, float f3, float f4, float f5, float f6, float f7, float f8);

    private native void nativeSetTransformState(float f2, float f3, float f4, float f5);

    private native boolean nativeSphereToScreenPoint(float f2, float f3, float f4, float[] fArr);

    public final void applyPointRotation(Vector3f vector3f, Vector3f vector3f2) {
        nativeApplyPointRotation(vector3f.x(), vector3f.y(), vector3f.z(), vector3f2.x(), vector3f2.y(), vector3f2.z());
    }

    public final native float getAspect();

    public final native float getDistance();

    public final native float getFar();

    public final native float getFov();

    public final native float getHorizontalAngle();

    public final native float getNear();

    public final native float getPitch();

    public CameraProjectionState getProjection() {
        CameraProjectionState cameraProjectionState = new CameraProjectionState(getFov(), getAspect(), getNear(), getFar(), getZoom(), getXScale(), getYScale());
        return cameraProjectionState;
    }

    public final native float getRoll();

    public CameraTransformState getTransformState() {
        return new CameraTransformState(getYaw(), getPitch(), getRoll(), getDistance());
    }

    public final native float getVerticalAngle();

    public final native float getXScale();

    public final native float getYScale();

    public final native float getYaw();

    public final native float getZoom();

    public final native void lock();

    public final native void moveHorizontal(float f2);

    public final void moveLookAt(Vector3f vector3f) {
        nativeMoveLookAt(vector3f.x(), vector3f.y(), vector3f.z());
    }

    public final native void moveVertical(float f2);

    public boolean screenToSpherePoint(Vector2f vector2f, Vector3f vector3f) {
        float[] fArr = new float[3];
        boolean nativeScreenToSpherePoint = nativeScreenToSpherePoint(vector2f.x, vector2f.y, fArr);
        vector3f.x = fArr[0];
        vector3f.y = fArr[1];
        vector3f.z = fArr[2];
        return nativeScreenToSpherePoint;
    }

    public final native void setAspect(float f2);

    public final native void setDistance(float f2);

    public final native void setFov(float f2);

    public final native void setPitch(float f2);

    public final void setProjection(CameraProjectionState cameraProjectionState) {
        nativeSetProjection(cameraProjectionState.getFov(), cameraProjectionState.getAspect(), cameraProjectionState.getNear(), cameraProjectionState.getFar(), cameraProjectionState.getZoom(), cameraProjectionState.getXScale(), cameraProjectionState.getYScale());
    }

    public final native void setRoll(float f2);

    public final void setTransformState(CameraTransformState cameraTransformState) {
        nativeSetTransformState(cameraTransformState.getYaw(), cameraTransformState.getPitch(), cameraTransformState.getRoll(), cameraTransformState.getDistance());
    }

    public final native void setXScale(float f2);

    public final native void setYScale(float f2);

    public final native void setYaw(float f2);

    public boolean sphereToScreenPoint(Vector3f vector3f, Vector2f vector2f) {
        float[] fArr = new float[2];
        boolean nativeSphereToScreenPoint = nativeSphereToScreenPoint(vector3f.x, vector3f.y, vector3f.z, fArr);
        vector2f.x = fArr[0];
        vector2f.y = fArr[1];
        return nativeSphereToScreenPoint;
    }

    public final native void unlock();

    public final native void updateHorizontalAngle(float f2);

    public final native void updateVerticalAngle(float f2);

    public final void withLock(Runnable runnable) {
        lock();
        try {
            runnable.run();
        } finally {
            unlock();
        }
    }

    public BaseCameraController(int i2) {
        this(createNativeWrap(), "BaseCameraController");
    }

    public BaseCameraController(long j2, String str) {
        super(j2, str);
    }
}
