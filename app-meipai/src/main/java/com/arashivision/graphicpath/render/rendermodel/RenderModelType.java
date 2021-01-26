package com.arashivision.graphicpath.render.rendermodel;

import com.arashivision.graphicpath.render.RenderLibsLoader;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public class RenderModelType extends NativeObjectRef {

    public static class DynamicStitchType {
        public static final int IMAGE = 1;
        public static final int TEMPLATE = 3;
        public static final int UNDEFINED = 0;
        public static final int VIDEO = 2;
    }

    public static class Type {
        public static final int AUTO = 0;
        public static final int PLANE = 20;
        public static final int PLANE_AUTO = 10;
        public static final int PLANE_EQUIRECTANGULAR = 12;
        public static final int PLANE_FISHEYE_DEWARP = 13;
        public static final int PLANE_STITCH = 11;
        public static final int SPHERE_AUTO = 1;
        public static final int SPHERE_FISHEYE_DEWARP = 4;
        public static final int SPHERE_PANORAMA_SOURCE = 3;
        public static final int SPHERE_STITCH = 2;
    }

    static {
        RenderLibsLoader.load();
    }

    public RenderModelType(int i2, String str) {
        this(createNativeWrap(i2, str));
    }

    public static native long createNativeWrap(int i2, String str);

    private native String desc();

    public static native boolean isOffsetCompatible(int i2, String str);

    @Deprecated
    public int GetPlaneRotationDegree() {
        return getPlaneRotationDegree();
    }

    @Deprecated
    public void SetPlaneRotationDegree(int i2) {
        setPlaneRotationDegree(i2);
    }

    public native void enableDebug(String str, boolean z, int i2);

    public native boolean getBlendAngleOptimizeEnable();

    public native float getBlendAngleRad();

    public native boolean getColorAdjustEnable();

    public native int getContentMode();

    public native boolean getDisableDirectionalInCamera();

    public native int getDynamicStitchAccuracyLevel();

    public native boolean getDynamicStitchDroneFlag();

    public native int getDynamicStitchType();

    public native float getFixedBoxFilteringSize();

    public native int getFlowstateMapHeight();

    public native int getFlowstateMapWidth();

    public native boolean getFrustumCullingEnable();

    public native int getHwAccelFlags();

    public native boolean getImageFusionEnable();

    public native int getImageLayoutValue();

    public native String getOffset();

    public native int getPlaneRotationDegree();

    public native int getPovMode();

    public native boolean getPreferDynamic();

    public native int getSphereSlices();

    public native int getSphereStacks();

    public native int getStitchInterval();

    public native int getType();

    public native boolean isApplyDictionalInCamera();

    public native boolean isAsyncStitch();

    public native boolean isOffsetCompatible(String str);

    public native void setAsyncStitch(boolean z);

    public native void setBlendAngleOptimizeEnable(boolean z);

    public native void setBlendAngleRad(float f2);

    public native void setColorAdjustEnable(boolean z);

    public native void setContentMode(int i2);

    public native void setDisableDirectionalInCamera(boolean z);

    public native void setDynamicStitchAccuracyLevel(int i2);

    public native void setDynamicStitchDroneFlag(boolean z);

    public native void setDynamicStitchType(int i2);

    public native void setFixedBoxFilteringSize(float f2);

    public native void setFlowstateMapHeight(int i2);

    public native void setFlowstateMapWidth(int i2);

    public native void setFrustumCullingEnable(boolean z);

    public native void setHwAccelFlags(int i2);

    public native void setImageFusionEnable(boolean z);

    public native void setImageLayoutValue(int i2);

    public native void setOffset(String str);

    public native void setPlaneRotationDegree(int i2);

    public native void setPovMode(int i2);

    public native void setPreferDynamic(boolean z);

    public native void setSphereSlices(int i2);

    public native void setSphereStacks(int i2);

    public native void setStitchInterval(int i2);

    public native void setType(int i2);

    public String toString() {
        return desc();
    }

    public RenderModelType(int i2) {
        this(createNativeWrap(i2, ""));
    }

    public RenderModelType(long j2) {
        this(j2, "RenderModelType");
    }

    public RenderModelType(long j2, String str) {
        super(j2, str);
    }
}
