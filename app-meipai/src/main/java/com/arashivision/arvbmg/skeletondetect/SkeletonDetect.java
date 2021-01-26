package com.arashivision.arvbmg.skeletondetect;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import java.util.List;

public class SkeletonDetect extends BMGNativeObjectRef {
    public SkeletonDetect() {
        this(nativeCreateSkeletonDetect());
    }

    public static native long nativeCreateSkeletonDetect();

    private native SkeletonVideoResult nativeLoadSkeletonJson(String str);

    private native SkeletonVideoResult nativeLoadSkeletonJsonList(List<String> list);

    private native SkeletonVideoResult nativeLoadSkeletonJsonStr(String str);

    private native void nativeSetDetectMode(SkeletonDetectInfo skeletonDetectInfo);

    public SkeletonVideoResult loadSkeletonJson(String str) {
        return nativeLoadSkeletonJson(str);
    }

    public SkeletonVideoResult loadSkeletonJsonList(List<String> list) {
        return nativeLoadSkeletonJsonList(list);
    }

    public SkeletonVideoResult loadSkeletonJsonStr(String str) {
        return nativeLoadSkeletonJsonStr(str);
    }

    public void setDetectMode(SkeletonDetectInfo skeletonDetectInfo) {
        nativeSetDetectMode(skeletonDetectInfo);
    }

    public SkeletonDetect(long j2) {
        super(j2, "SkeletonDetect");
    }
}
