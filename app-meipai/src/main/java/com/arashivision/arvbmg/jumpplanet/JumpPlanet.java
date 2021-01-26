package com.arashivision.arvbmg.jumpplanet;

import com.arashivision.arvbmg.exporter.FrameExporterSample;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class JumpPlanet extends BMGNativeObjectRef {
    public JumpPlanet() {
        this(nativeCreateJumpPlantObj());
    }

    private void checkUrls(String[] strArr) {
        if (strArr == null) {
            throw new NullPointerException("input urls should not empty");
        }
    }

    public static native long nativeCreateJumpPlantObj();

    private native JumpResult nativeDetectMove(FrameExporterSample frameExporterSample, JumpDetectInfo jumpDetectInfo);

    private native JumpTrimInfo nativeInputUrlStabilizer(String[] strArr);

    private native void nativeSetDebug(boolean z);

    public JumpTrimInfo inputUrls(String[] strArr) {
        checkUrls(strArr);
        return nativeInputUrlStabilizer(strArr);
    }

    public JumpResult moveDetect(FrameExporterSample frameExporterSample, JumpDetectInfo jumpDetectInfo) {
        return nativeDetectMove(frameExporterSample, jumpDetectInfo);
    }

    public void setDebug(boolean z) {
        nativeSetDebug(z);
    }

    public JumpPlanet(long j2) {
        super(j2, "JumpPlanet");
    }
}
