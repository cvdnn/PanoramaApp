package com.arashivision.graphicpath.render.base;

import com.arashivision.graphicpath.render.RenderLibsLoader;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public class SphereViewMode extends NativeObjectRef {

    public static class Type {
        public static final int ASTEROID = 2;
        public static final int CUSTOM = 100;
        public static final int FISHEYE = 0;
        public static final int MAGICBALL = 3;
        public static final int NUM = 4;
        public static final int PERSPECTIVE = 1;
    }

    static {
        RenderLibsLoader.load();
    }

    public SphereViewMode() {
        this(createNativeWrap());
    }

    public static native long createNativeWrap();

    public static native long createNativeWrap(float f2, float f3, float f4, boolean z);

    private native float getMaxDistance();

    private native float getMaxFov();

    private native float getMaxPitchAngle();

    private native float getMaxYaw();

    private native float getMinDistance();

    private native float getMinFov();

    private native float getMinPitchAngle();

    private native float getMinYaw();

    public static native long nativeOfType(int i2, boolean z);

    private native void nativeSetCameraConstraint(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9);

    public static SphereViewMode ofType(int i2) {
        return new SphereViewMode(nativeOfType(i2, false));
    }

    public CameraConstraint getCameraConstraint() {
        CameraConstraint cameraConstraint = new CameraConstraint(getMinPitchAngle(), getMaxPitchAngle(), getMinFov(), getMaxFov(), getMinDistance(), getMaxDistance(), getMinYaw(), getMaxYaw());
        return cameraConstraint;
    }

    public native float getDistance();

    public native float getFov();

    public native float getPitchAngle();

    public native int getType();

    public native boolean isWithSwitchingAnimation();

    public void setCameraConstraint(CameraConstraint cameraConstraint) {
        nativeSetCameraConstraint(cameraConstraint.getMinPitch(), cameraConstraint.getMaxPitch(), cameraConstraint.getMinFov(), cameraConstraint.getMaxFov(), cameraConstraint.getMinDistance(), cameraConstraint.getMaxDistance(), cameraConstraint.getMinYaw(), cameraConstraint.getMaxYaw());
    }

    public native void setType(int i2);

    public native void setWithSwitchingAnimation(boolean z);

    public SphereViewMode(float f2, float f3, float f4, CameraConstraint cameraConstraint, boolean z) {
        this(createNativeWrap(f2, f3, f4, z));
        setCameraConstraint(cameraConstraint);
    }

    public static SphereViewMode ofType(int i2, boolean z) {
        return new SphereViewMode(nativeOfType(i2, z));
    }

    public SphereViewMode(long j2) {
        super(j2, "SphereViewMode");
    }
}
