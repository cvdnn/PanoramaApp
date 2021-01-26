package com.arashivision.arvbmg.rolling;

import com.arashivision.arvbmg.exporter.FrameExporterSample;
import com.arashivision.arvbmg.jumpplanet.JumpDetectInfo;
import com.arashivision.arvbmg.jumpplanet.JumpResult;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class Rolling extends BMGNativeObjectRef {
    public Rolling() {
        this(nativeCreateRollingObj());
    }

    private void checkUrls(String[] strArr) {
        if (strArr == null) {
            throw new NullPointerException("input urls should not empty");
        }
    }

    public static native long nativeCreateRollingObj();

    private native JumpResult nativeDetectMove(FrameExporterSample frameExporterSample, JumpDetectInfo jumpDetectInfo);

    private native RollingTrimInfo nativeGetRollingInfo(String[] strArr);

    private native void nativeSetDebug(boolean z);

    public RollingTrimInfo inputUrls(String[] strArr) {
        checkUrls(strArr);
        return nativeGetRollingInfo(strArr);
    }

    public JumpResult moveDetect(FrameExporterSample frameExporterSample, JumpDetectInfo jumpDetectInfo) {
        return nativeDetectMove(frameExporterSample, jumpDetectInfo);
    }

    public void setDebug(boolean z) {
        nativeSetDebug(z);
    }

    public Rolling(long j2) {
        super(j2, "Rolling");
    }
}
