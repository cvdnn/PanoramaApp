package com.arashivision.algorithm;

import com.arashivision.arvbmg.exporter.FrameExporterSample;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.arvbmg.util.ARVBMGLibsLoader;
import java.util.List;

public class ProtectorsOffset extends BMGNativeObjectRef {
    static {
        ARVBMGLibsLoader.load();
    }

    public ProtectorsOffset() {
        this(nativeCreateProtectors());
    }

    private void checkOffsetAndImageSize(List<String> list, List<String> list2) {
        if (list == null || list2 == null) {
            throw new NullPointerException("offset list nor image list should not empty");
        } else if (list.size() < 2) {
            throw new IllegalArgumentException("offset list size is error");
        }
    }

    public static String getOptimalOffset2(String[] strArr, FrameExporterSample[] frameExporterSampleArr) {
        if (strArr == null && strArr.length < 2) {
            throw new NullPointerException("offsetList null or offsetlist length not 3");
        } else if (frameExporterSampleArr != null && frameExporterSampleArr.length != 0) {
            return nativeGetOptimalOffset2(strArr, frameExporterSampleArr);
        } else {
            throw new NullPointerException("frameExporterSamples null or length 0");
        }
    }

    private native String nativeConvertOffset(String str, String str2);

    public static native long nativeCreateProtectors();

    private native String nativeGetOptimalOffset(List<String> list, List<String> list2);

    public static native String nativeGetOptimalOffset2(String[] strArr, FrameExporterSample[] frameExporterSampleArr);

    public String convertOffset(String str, String str2) {
        return nativeConvertOffset(str, str2);
    }

    public String getOptimalOffset(List<String> list, List<String> list2) {
        checkOffsetAndImageSize(list, list2);
        return nativeGetOptimalOffset(list, list2);
    }

    public ProtectorsOffset(long j2) {
        super(j2, "ProtectorsOffset");
    }
}
