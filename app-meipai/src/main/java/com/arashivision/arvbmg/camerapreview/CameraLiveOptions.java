package com.arashivision.arvbmg.camerapreview;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class CameraLiveOptions extends BMGNativeObjectRef {
    public CameraLiveOptions(String str, int i2, int i3, int i4, int i5, String str2, int i6, boolean z, boolean z2, String str3, boolean z3, int i7, int i8, int i9, long j2) {
        this(createNativeWrap(str, i2, i3, i4, i5, str2, i6, z, z2, str3, z3, i7, i8, i9, j2));
        setRequireFreeManually();
    }

    public static native long createNativeWrap(String str, int i2, int i3, int i4, int i5, String str2, int i6, boolean z, boolean z2, String str3, boolean z3, int i7, int i8, int i9, long j2);

    public CameraLiveOptions(long j2) {
        super(j2, "CameraLiveOptions");
    }
}
