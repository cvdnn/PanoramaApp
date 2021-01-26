package com.arashivision.algorithm;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class SeamlessBlender extends BMGNativeObjectRef {

    public static class BLENDER_TYPE {
        public static final int BGR_CPU = 0;
        public static final int BGR_CUDA = 1;
        public static final int BGR_OPENCL = 2;
        public static final int BGR_OPENCL2 = 3;
        public static final int NV12_CPU = 4;
        public static final int NV12_CUDA = 5;
        public static final int NV12_CUDA_ARRAY = 6;
        public static final int NV12_OPENCL = 7;
        public static final int NV12_OPENCL2 = 8;
        public static final int RAW_CPU = 13;
        public static final int RAW_CUDA = 14;
        public static final int RAW_OPENCL = 15;
        public static final int RAW_OPENCL2 = 16;
        public static final int YUV420P_CPU = 9;
        public static final int YUV420P_CUDA = 10;
        public static final int YUV420P_OPENCL = 11;
        public static final int YUV420P_OPENCL2 = 12;
    }

    public static class BlenderMap {
        public float[] data;
        public int height;
        public int width;
    }

    public SeamlessBlender(int i2) {
        this(createNativeWrap(i2));
    }

    public static native long createNativeWrap(int i2);

    public static void getLeftRightColorAdjust(int i2, int i3, String str, BlenderMap[] blenderMapArr) {
        nativeGetLeftRightColorAdjust(i2, i3, str, blenderMapArr);
    }

    public static void getLeftRightColorAdjustRotate(int i2, int i3, String str, float f2, float f3, float f4, BlenderMap[] blenderMapArr) {
        nativeGetLeftRightColorAdjustRotate(i2, i3, str, f2, f3, f4, blenderMapArr);
    }

    public static native void nativeGetLeftRightColorAdjust(int i2, int i3, String str, BlenderMap[] blenderMapArr);

    public static native void nativeGetLeftRightColorAdjustRotate(int i2, int i3, String str, float f2, float f3, float f4, BlenderMap[] blenderMapArr);

    public native int blendImage(String str, String str2, int i2, int i3);

    public native int blendImageWithNotSetImage(String str, String str2, int i2, int i3);

    public native void cancelBlend();

    public native void getLeftAlpha(BlenderMap blenderMap);

    public native void getLeftMap(BlenderMap blenderMap);

    public native void getRightMap(BlenderMap blenderMap);

    public native void init(int i2, int i3, String str);

    public native void setBlendAngle(float f2);

    public native int setImageData(int[] iArr);

    public native int setImagePath(String str);

    public native void setMapSize(int i2, int i3);

    public SeamlessBlender(long j2) {
        super(j2, "SeamlessBlender");
    }
}
